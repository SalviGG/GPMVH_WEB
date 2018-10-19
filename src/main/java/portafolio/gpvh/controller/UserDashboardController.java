package portafolio.gpvh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserDashboardController {

    @GetMapping("/userDashboard")
    public String userDashboard(Authentication authentication){

       // int rut = Integer.parseInt( (String)httpSession.getAttribute("username"));
       // System.out.println(rut);

        return "userDashboard";
    }
}
