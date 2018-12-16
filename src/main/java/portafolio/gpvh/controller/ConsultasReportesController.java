package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.model.entity.Departamento;
import portafolio.gpvh.model.entity.EstadoDocumento;
import portafolio.gpvh.model.service.DepartamentoService;
import portafolio.gpvh.model.service.EstadoDocumentoService;
import portafolio.gpvh.model.service.MotivoService;
import portafolio.gpvh.model.service.TipoDocumentoService;

import javax.servlet.http.HttpSession;

@Controller
public class ConsultasReportesController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;

    @Autowired
    private MotivoService motivoService;

    @GetMapping("/consultasReportes")
    public String consultasReportes(HttpSession session){

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        return "consultasReportes";
    }

    @GetMapping("/consultaReportes")
    public String busquedaEspecifica(Model model){

        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoDoc", estadoDocumentoService.findAll() );
        model.addAttribute("listadoMotivo", motivoService.findAll());

        return "formularioReportesConsultas";
    }


}
