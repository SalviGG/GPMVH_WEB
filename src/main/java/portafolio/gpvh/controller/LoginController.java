package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.service.serviceIMPL.ConsultaControlAccesoServicioIMPL;

@Controller
//@RequestMapping("/")
public class LoginController {

    @Autowired
    private ConsultaControlAccesoServicioIMPL consultaControlAccesoServicioIMPL;

    @GetMapping("/login")
    public String login(){
        return "login";
    }




}
