package portafolio.gpvh.controller;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.model.entity.Departamento;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.EstadoDocumento;
import portafolio.gpvh.model.service.*;

import javax.servlet.http.HttpSession;
import java.awt.*;

@Controller
public class ConsultasReportesController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;

    @Autowired
    private MotivoService motivoService;

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/consultasReportes")
    public String consultaDeLosRepos(HttpSession session, Model model){

        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";
        }

        return "consultasReportes";
    }

    @GetMapping("/consultaResoluciones")
    public String busquedaReportes(HttpSession session, Model model) {

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());

        return "consultaResoluciones";
    }
    @PostMapping("/cosultaResoluciones")
    public String PostBusquedaResoluciones(HttpSession session, Model model, @RequestParam("busqueda") String rut,
                                           @RequestParam("inputText") String inputText,
                                           @RequestParam("departamento") String departamento,
                                           @RequestParam("motivo")String motivo){

        if(session.getAttribute("persona")==null){
            return "redirect:/dashboard";
        }
        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());



        System.out.println(departamento);
        System.out.println(motivo);
        System.out.println(inputText);


        return "consultaResoluciones";
    }


    @GetMapping("/informePermisos")
    public String busquedaInformes(HttpSession session ,Model model) {

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";

        }
        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoDoc", estadoDocumentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());
        return "informePermisos";

    }

    @PostMapping("/InfomePermisos")
    public String PostBusquedaInformes(Model model,  @RequestParam("busqueda") String rut,
                                       @RequestParam("inputText") String inputText,
                                       @RequestParam("departamento") String departamento,
                                       @RequestParam("motivo")String motivo,
                                       @RequestParam("estado") String estado){

        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoDoc", estadoDocumentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());

        System.out.println(inputText);
        System.out.println(departamento);
        System.out.println(motivo);
        System.out.println(estado);

        return "informePermisos";
    }
}
