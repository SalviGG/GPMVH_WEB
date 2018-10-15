package portafolio.gpvh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormularioSolicitudesController {

    @GetMapping("/formularioSolicitudes")
    public String formulario(){
        return "formularioSolicitudes";
    }
}
