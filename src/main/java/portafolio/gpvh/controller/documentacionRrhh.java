package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.model.service.DocumentoService;


@Controller
public class documentacionRrhh {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/rrhh")
    public String rrhh(Model model){

        model.addAttribute("listaDocumento",documentoService.findAllConDocumento());

        return "rrhh";
    }

}
