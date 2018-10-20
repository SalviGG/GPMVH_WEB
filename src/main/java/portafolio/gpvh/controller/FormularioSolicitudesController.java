package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.model.entity.Motivo;
import portafolio.gpvh.model.service.MotivoService;

@Controller
public class FormularioSolicitudesController {

    @Autowired
    private MotivoService motivoService;

    @GetMapping("/formularioSolicitudes")
    public String formulario(Model model){
        //Valida que el atributo archivo no este vacio 
        if (!model.containsAttribute("archivo")){
            return "redirect:/solicitud";
        }
        model.addAttribute("archivo","fragments/opcionesRapidas");
        model.addAttribute("nombreFragment","opcionesRapidas");
        return "formularioSolicitudes";
    }

    @PostMapping("/formularioSolicitudes")
    public String postFormulario(Model model,@RequestParam("motivoId") String motivoId) {
        System.out.println(motivoId);
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
