package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.model.service.FuncionarioService;

import javax.servlet.http.HttpSession;

@Controller
public class Dashboard {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ConsultaControlAccesoServicio consultaControlAccesoServicio;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, HttpSession httpSession){

        int rut = Integer.parseInt(authentication.getName());

        Persona persona = consultaControlAccesoServicio.busquedaPorRut(rut);
        httpSession.setAttribute("persona" ,persona);
        httpSession.setAttribute("funcionario",funcionarioService.buscarPorRut(rut));

        return "dashboard";
    }
}
