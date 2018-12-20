package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.EstadoDocumentoService;

import javax.servlet.http.HttpSession;


@Controller
public class documentacionRrhh {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;


    @GetMapping("/rrhh")
    public String rrhh(Model model, HttpSession session){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        String mensaje= (String) model.asMap().get("mensaje");
        model.addAttribute("listaDocumento",documentoService.findAllConDocumento());
        model.addAttribute("permisosRevision", documentoService.countDocumentosRevision());
        model.addAttribute("mensaje",mensaje);


        return "rrhh";
    }

    @PostMapping("/rrhh")
    public String documentacion(Model model, @RequestParam("id") String id, @RequestParam("aprobacion") String aprobacion, HttpSession session, RedirectAttributes redirectAttributes){

        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        String mensaje = "";

        if (aprobacion.equals("aprobado")){
             mensaje = "El permiso ha sido " + aprobacion;
             Documento documento = documentoService.findOne(Integer.parseInt(id));
             documento.setEstadoDocumentoId(estadoDocumentoService.findOne(4));//Estado id=4 Pendiente
             documentoService.save(documento);
        }else {
            mensaje = "El permiso ha sido " + aprobacion;
            Documento documento = documentoService.findOne(Integer.parseInt(id));
            documento.setEstadoDocumentoId(estadoDocumentoService.findOne(5));//Estado id=5 Rechazado
            documentoService.save(documento);
        }

        redirectAttributes.addFlashAttribute("mensaje", mensaje);

        model.addAttribute("permisosRevision", documentoService.countDocumentosRevision());

        return "redirect:/rrhh";
    }

}
