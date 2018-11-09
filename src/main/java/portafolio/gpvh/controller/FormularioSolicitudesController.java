package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.model.entity.Documento;

import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.EstadoDocumentoService;
import portafolio.gpvh.model.service.MotivoService;
import portafolio.gpvh.model.service.TipoDocumentoService;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormularioSolicitudesController {

    @Autowired
    private MotivoService motivoService;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private EstadoDocumentoService estadoDocumentoService;
    @Autowired
    private DocumentoService documentoService;
// buscar como llamar a parametro file, en spring controller
    @PostMapping("/GuardarPermisosMatrimonio")
    public String postGuardarPermisosMatrimonio(HttpSession session,@RequestParam("fecha_inicial") String fechaInicial){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        return "redirect:/solicitudes";

    }

    @PostMapping("/GuardarHorasCompesadas")
    public String postGuardarHorasCompesadas(HttpSession session,@RequestParam("fecha") String fecha,@RequestParam("inicio") String inicio,@RequestParam("termino") String termino){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date fechaDate;
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(1));
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(1));
        documento.setFechaSolicitud(new Date());
        documento.setUltimaFechaModificacion(new Date());
        try {
            fechaDate = formatter.parse(fecha + " "+inicio+":00:00");
            documento.setFechaInicio(fechaDate);
            fechaDate = formatter.parse(fecha + " "+termino+":00:00");
            documento.setFechaTermino(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        documentoService.save(documento);
        return "redirect:/solicitud";
    }

    @PostMapping("/GuardarDiaAdministrativo")
    public String postGuardarDiaAdministrativo(HttpSession session,@RequestParam("periodo") String periodo,@RequestParam("fecha") String fecha){



        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date fechaDate;
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(2));
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(1));
        try {

            documento.setFechaSolicitud(new Date());
            documento.setUltimaFechaModificacion(new Date());
            if(periodo.equals("1")) {
                fechaDate = formatter.parse(fecha + " 08:00:00");
                documento.setFechaInicio(fechaDate);
                fechaDate = formatter.parse(fecha + " 19:00:00");
                documento.setFechaTermino(fechaDate);
            }else if(periodo.equals("2")){
                fechaDate = formatter.parse(fecha + " 08:00:00");
                documento.setFechaInicio(fechaDate);
                fechaDate = formatter.parse(fecha + " 13:00:00");
                documento.setFechaTermino(fechaDate);
            }else if(periodo.equals("3")){
                fechaDate = formatter.parse(fecha + " 13:00:00");
                documento.setFechaInicio(fechaDate);
                fechaDate = formatter.parse(fecha + " 19:00:00");
                documento.setFechaTermino(fechaDate);
            }
        } catch (ParseException e) {
            System.out.println(fecha);
        }
        documentoService.save(documento);
        System.out.println(documento.getFechaInicio());
        System.out.println(documento.getFechaTermino());

        return "redirect:/solicitud";
    }

    @GetMapping("/formularioSolicitudes")
    public String formulario(Model model){
        //Validación de session para evitar error de atributo null
        if (!model.containsAttribute("archivo")){
            return "redirect:/solicitud";
        }
        model.addAttribute("archivo","fragments/opcionesRapidas");
        model.addAttribute("nombreFragment","opcionesRapidas");
        return "formularioSolicitudes";
    }

    @PostMapping("/formularioSolicitudes")
    public String postFormulario(Model model,@RequestParam("motivoId") String motivoId) {



        Motivo motivo = motivoService.findOne(Integer.parseInt(motivoId));
        model.addAttribute("motivo", motivo);
        switch (motivo.getMotivoId()) {
            case 1:
                model.addAttribute("archivoForm", "fragments/horasCompensadas");
                model.addAttribute("nombreFragmentForm", "horasCompensadas");
                break;
            case 2:

                model.addAttribute("archivoForm", "fragments/administrativo");
                model.addAttribute("nombreFragmentForm", "administrativo");
                break;
            case 3:
                model.addAttribute("archivoForm", "fragments/vacaciones");
                model.addAttribute("nombreFragmentForm", "vacaciones");
                break;
            case 13:
                model.addAttribute("archivoForm", "fragments/matrimonio");
                model.addAttribute("nombreFragmentForm", "matrimonio");
                break;
            default:
                model.addAttribute("archivoForm", "fragments/otros");
                model.addAttribute("nombreFragmentForm", "otros");
                break;
        }

        model.addAttribute("archivo","fragments/opcionesRapidas");
        model.addAttribute("nombreFragment","opcionesRapidas");


        return "formularioSolicitudes";
    }
}
