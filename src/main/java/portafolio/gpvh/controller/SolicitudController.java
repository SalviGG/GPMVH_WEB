package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.model.service.MotivoService;

import javax.servlet.http.HttpSession;

@Controller
public class SolicitudController {

    @Autowired
    private MotivoService motivoService;

    @GetMapping("/solicitud")
    public String solicitud(Model model, HttpSession session, @RequestParam(name="mensaje",defaultValue = "null") String mensaje,@RequestParam(name="error",defaultValue = "null") String error){
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        System.out.println("mensaje Recivido ="+mensaje);
        if(!mensaje.equals("null") ){
            model.addAttribute("mensaje","La solicitud fue creada corectamente con el numero:"+ mensaje);
        }
        model.addAttribute("motivos",motivoService.findAllActivo());
        return "solicitud";
    }
}
