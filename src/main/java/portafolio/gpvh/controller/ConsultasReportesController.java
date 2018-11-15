package portafolio.gpvh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ConsultasReportesController {

    @GetMapping("/consultasReportes")
    public String consultasReportes(HttpSession session){

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        return "formularioReportesConsultas";
    }

}
