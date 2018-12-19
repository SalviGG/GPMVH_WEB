package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/rrhh")
    public String documentacion(Model model, @RequestParam("id") String id, @RequestParam("aprobado") String aprobado, @RequestParam("rechazado") String rechazado){

        String mensaje = "";
        if (aprobado != null){
             mensaje = "Su permiso ha sido " + aprobado;
        }else {
            mensaje = "Su permiso ha sido " + rechazado;
        }

        System.out.println(mensaje + " " +id);

        return "redirect:/dashboard";
    }

}
