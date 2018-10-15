package portafolio.gpvh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String loginCorrecto(){
        return "redirect:/dashboard";
    }



}
