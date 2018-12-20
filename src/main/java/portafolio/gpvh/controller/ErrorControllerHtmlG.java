package portafolio.gpvh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.boot.web.servlet.error.ErrorController;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorControllerHtmlG implements ErrorController {

    @GetMapping( "/error")
    public String error(HttpServletRequest httpRequest){

        return "redirect:/dashboard";
    }
    @PostMapping("/error")
    public String errorPost(HttpServletRequest httpRequest){
        return "redirect:/dashboard";
    }

    @Override
    public String getErrorPath() {
        return "redirect:/dashboard";
    }
}
