package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.model.service.MotivoService;

import javax.servlet.http.HttpSession;

@Controller
public class SolicitudController {

    @Autowired
    private MotivoService motivoService;

    @GetMapping("/solicitud")
    public String solicitud(Model model, HttpSession session){

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        //System.out.println(((Persona)session.getAttribute("persona")).getNombres());
        model.addAttribute("motivos",motivoService.findAllActivo());
        return "solicitud";

    }
}
