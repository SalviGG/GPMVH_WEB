package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.DateUtils;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.model.dao.IDocumentoDao;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Resolucion;
import portafolio.gpvh.model.entity.TipoDocumento;
import portafolio.gpvh.model.service.*;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ConsultaPermisoController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private MotivoService motivoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private ConsultaControlAccesoServicio consultaControlAccesoServicio;

    public int diferenciaFechasHoras( Date fechaMayor , Date fechaMenor) {
        int diferencia=(int) ((fechaMayor.getTime()-fechaMenor.getTime())/1000);
        int horas = 0;
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
        }
        return horas;
    }

    public  Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    @PostMapping("/anularPermiso")
    public String anularMotivo(HttpSession session,@RequestParam("documentoId")String documentoId,@RequestParam("comentario")String comentario,@RequestParam("motivo")String motivo){
        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        Funcionario funcionario = (Funcionario)session.getAttribute("funcionario");
        Documento documentoANular = documentoService.findOne(Integer.parseInt(documentoId));
        documentoANular.setEstadoDocumentoId(estadoDocumentoService.findOne(7));
        if(documentoANular.getMotivoId().getMotivoId() == 1){
            int horas = diferenciaFechasHoras(documentoANular.getFechaTermino(),documentoANular.getFechaInicio());
            Persona persona = (Persona) session.getAttribute("persona");
            consultaControlAccesoServicio.devolverHoras(persona,horas);
        }else if(documentoANular.getMotivoId().getMotivoId() == 3){
            int dias = (int) ((documentoANular.getFechaTermino().getTime()-documentoANular.getFechaInicio().getTime())/86400000);
            funcionario.setDiaVacaciones(funcionario.getDiaVacacionesUsadas() - dias);
            funcionarioService.save(funcionario);
        }else if(documentoANular.getMotivoId().getMotivoId() == 2){
            int horas = diferenciaFechasHoras(documentoANular.getFechaTermino(),documentoANular.getFechaInicio());
            if(horas > 6){
                funcionario.setDiasAdministrativoUsados(funcionario.getDiasAdministrativoUsados()-1.0);
            }else{
                funcionario.setDiasAdministrativoUsados(funcionario.getDiasAdministrativoUsados()-0.5);
            }
            funcionarioService.save(funcionario);
        }
        documentoService.save(documentoANular);
        Documento documentoParaAnular = new Documento();
        documentoParaAnular.setAfectaDocumentoId(documentoANular);
        documentoParaAnular.setTipoDocumentoId(tipoDocumentoService.findOne(2));
        documentoParaAnular.setFuncionarioId(funcionario);
        documentoParaAnular.setMotivoId(motivoService.findOne(Integer.parseInt(motivo)));
        documentoParaAnular.setEstadoDocumentoId(estadoDocumentoService.findOne(6));
        documentoParaAnular.setFechaSolicitud(new Date());
        documentoParaAnular.setUltimaFechaModificacion(new Date());
        documentoParaAnular.setComentario(comentario);
        documentoService.save(documentoParaAnular);
        return "redirect:/consultaPermiso";
    }

    @GetMapping("/consultaPermiso")
    public String formularioP(Model model, HttpSession session){

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        System.out.println(documentoService.findAllByFuncionarioId(funcionario).size());
        model.addAttribute("listaDocumento",documentoService.findAllByFuncionarioId(funcionario));
        model.addAttribute("listMotivoAnulacion",motivoService.findAllActivoAnulacion());
        Date fechaActual = removeTime(new Date());
        model.addAttribute("fechaActual" ,fechaActual);
        return "consultaPermiso";
    }

    @GetMapping("/consultaResoluciones")
    public String consultasDeResoluciones(){

        return "consultaResoluciones";
    }

    @GetMapping("/reportePermisos")
    public String reporteDePermisos(){


        return "reportePermisos";
    }

}