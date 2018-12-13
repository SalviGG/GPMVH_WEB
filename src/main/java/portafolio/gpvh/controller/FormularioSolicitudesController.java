package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import portafolio.gpvh.model.entity.Documento;

import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.EstadoDocumentoService;
import portafolio.gpvh.model.service.MotivoService;
import portafolio.gpvh.model.service.TipoDocumentoService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.spi.CalendarNameProvider;

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


    @PostMapping("/GuardarPermisosDefuncion")
    public String postGuardarPermisosDefuncion(HttpSession session,@RequestParam("fecha_defuncion")String fechaDefuncion,@RequestParam("tipoDefuncion")String tipoDefuncion, @RequestParam("file")MultipartFile archivo, RedirectAttributes flash){
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }

        if(!archivo.isEmpty()){
            Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = archivo.getBytes();
                Path rutaCompleta = Paths.get(rootPath +"//" + archivo.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                flash.addFlashAttribute("info", "Has subido correctamente '" + archivo.getOriginalFilename() + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date fecha;
        Calendar calendar = Calendar.getInstance();
        Funcionario funcionario=(Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(12));//id 12 = motivo defuncion
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));//id 1 = solicitud de permiso
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(1));//id 1 = estado solicitado
        documento.setFechaSolicitud(new Date());
        documento.setUltimaFechaModificacion(new Date());
        documento.setUrlDocumentoAdjunto(archivo.getOriginalFilename());

        try {
            fecha = formatter.parse(fechaDefuncion);
            documento.setFechaInicio(fecha);
            fecha = formatter.parse(fechaDefuncion);
            calendar.setTime(fecha);
            if (Integer.parseInt(tipoDefuncion)==1){

                calendar.add(Calendar.DAY_OF_MONTH,6);
            }else{

                int diasPermiso = 2;
                for (int i=0;i<diasPermiso;){
                    calendar.add(Calendar.DAY_OF_MONTH,1);
                    if (calendar.get(Calendar.DAY_OF_WEEK)>=Calendar.MONDAY && calendar.get(Calendar.DAY_OF_WEEK)<=Calendar.FRIDAY){
                        i++;
                    }
                }
            }
            fecha= calendar.getTime();
            documento.setFechaTermino(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        documentoService.save(documento);
        System.out.println(documento.getFechaInicio());
        System.out.println(documento.getFechaTermino());
        return "redirect:/solicitud";
    }


    @PostMapping("/GuardarPermisosMatrimonio")
    public String postGuardarPermisosMatrimonio(HttpSession session, @RequestParam("fecha_inicial") String fechaInicial, @RequestParam("file")MultipartFile archivo, RedirectAttributes flash){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }

        if(!archivo.isEmpty()){
            Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = archivo.getBytes();
                Path rutaCompleta = Paths.get(rootPath +"//" + archivo.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                flash.addFlashAttribute("info", "Has subido correctamente '" + archivo.getOriginalFilename() + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date fecha;
        Calendar calendar = Calendar.getInstance();
        Funcionario funcionario=(Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(13));//id 13 = motivo matrimonio
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));//id 1 = solicitud de permiso
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(4));//id 4 = estado pendiente
        documento.setFechaSolicitud(new Date());
        documento.setUltimaFechaModificacion(new Date());
        documento.setUrlDocumentoAdjunto(archivo.getOriginalFilename());
        try {
            fecha = formatter.parse(fechaInicial);
            documento.setFechaInicio(fecha);
            fecha = formatter.parse(fechaInicial);
            calendar.setTime(fecha);
            int diasPermiso = 4;
            for (int i=0;i<diasPermiso;){
                calendar.add(Calendar.DAY_OF_MONTH,1);
                if (calendar.get(Calendar.DAY_OF_WEEK)>=Calendar.MONDAY && calendar.get(Calendar.DAY_OF_WEEK)<=Calendar.FRIDAY){
                    i++;
                }
            }
            fecha= calendar.getTime();
            documento.setFechaTermino(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        documentoService.save(documento);
        System.out.println(documento.getFechaInicio());
        System.out.println(documento.getFechaTermino());
        return "redirect:/solicitud";
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

    @PostMapping("/GuardarVacaciones")
    public String postGuardarVacaciones(HttpSession session,@RequestParam("numero_dias") String fechas){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        //tranformo la fecha compuesta en 2 valores distintos
        String[] parts = fechas.split("-");
        String inicio = parts[0]; // fecha inicio
        String termino = parts[1]; // fecha termino

        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date fechaDate;
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(3));
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(1));
        documento.setFechaSolicitud(new Date());
        documento.setUltimaFechaModificacion(new Date());
        try {
            fechaDate = formatter.parse(inicio);
            documento.setFechaInicio(fechaDate);
            fechaDate = formatter.parse(termino);
            documento.setFechaTermino(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        documentoService.save(documento);

        return "redirect:/solicitud";
    }

    @PostMapping("/GuardarOtros")
    public String postGuardarOtros(HttpSession session,@RequestParam("numero_dias") String fechas, @RequestParam("file")MultipartFile archivo, @RequestParam("tipoDia") String idTipo_nesesita,RedirectAttributes flash){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        //tranformo la fecha compuesta en 2 valores distintos
        String[] parts = fechas.split("-");
        String inicio = parts[0]; // fecha inicio
        String termino = parts[1]; // fecha termino

        //tranformo el id compuesto a id simple id primera posicion nesesita o no segunda posicion
        String[] compuesto = idTipo_nesesita.split("-");
        int idOtros =Integer.parseInt(compuesto[0]); // id del tipo seleccionado tranformo en id
        String nesesita = compuesto[1]; // nesesota o no nesesita

        // manejo el archivo seleccionado
        //si nesesita documento entra
        if (nesesita =="s" || nesesita=="S") {
        if(!archivo.isEmpty()){
            Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = archivo.getBytes();
                Path rutaCompleta = Paths.get(rootPath +"//" + archivo.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                flash.addFlashAttribute("info", "Has subido correctamente '" + archivo.getOriginalFilename() + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }}


        Documento documento = new Documento();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date fechaDate;
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        documento.setFuncionarioId(funcionario);
        documento.setMotivoId(motivoService.findOne(idOtros));
        documento.setTipoDocumentoId(tipoDocumentoService.findOne(1));
        documento.setEstadoDocumentoId(estadoDocumentoService.findOne(1));
        documento.setFechaSolicitud(new Date());
        documento.setUltimaFechaModificacion(new Date());
        if (nesesita =="s" || nesesita=="S") {// si nenesita documento
            documento.setUrlDocumentoAdjunto(archivo.getOriginalFilename());
        }
        try {
            fechaDate = formatter.parse(inicio);
            documento.setFechaInicio(fechaDate);
            fechaDate = formatter.parse(termino);
            documento.setFechaTermino(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        documentoService.save(documento);

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
            case 12:
                model.addAttribute("archivoForm", "fragments/defuncion");
                model.addAttribute("nombreFragmentForm", "defuncion");
                break;
            default:
                List<Motivo> otrosMotiv = otrosFormularios();
                model.addAttribute("otrosMotiv", otrosMotiv);
                model.addAttribute("archivoForm", "fragments/otros");
                model.addAttribute("nombreFragmentForm", "otros");
                break;
        }

        model.addAttribute("archivo","fragments/opcionesRapidas");
        model.addAttribute("nombreFragment","opcionesRapidas");


        return "formularioSolicitudes";
    }


    public List<Motivo> otrosFormularios(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(12);
        list.add(13);
        return  motivoService.findAllOtros(list);
   }
}
