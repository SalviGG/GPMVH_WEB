package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.EstadoDocumentoService;


@Controller
public class documentacionRrhh {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;


    @GetMapping("/rrhh")
    public String rrhh(Model model){

        model.addAttribute("listaDocumento",documentoService.findAllConDocumento());
        model.addAttribute("permisosRevision", documentoService.countDocumentosRevision());

        return "rrhh";
    }

    @PostMapping("/rrhh")
    public String documentacion(Model model, @RequestParam("id") String id, @RequestParam("aprobacion") String aprobacion){

        String mensaje = "";

        if (aprobacion.equals("aprobado")){
             mensaje = "Su permiso ha sido " + aprobacion;
             Documento documento = documentoService.findOne(Integer.parseInt(id));
             documento.setEstadoDocumentoId(estadoDocumentoService.findOne(4));//Estado id=4 Pendiente
             documentoService.save(documento);
        }else {
            mensaje = "Su permiso ha sido " + aprobacion;
            Documento documento = documentoService.findOne(Integer.parseInt(id));
            documento.setEstadoDocumentoId(estadoDocumentoService.findOne(5));//Estado id=5 Rechazado
            documentoService.save(documento);
        }

        System.out.println(mensaje + " " +id);
        model.addAttribute("permisosRevision", documentoService.countDocumentosRevision());

        return "redirect:/rrhh";
    }

}
