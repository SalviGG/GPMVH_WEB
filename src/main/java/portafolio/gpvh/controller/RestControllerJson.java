package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.service.DocumentoService;

@RestController
public class RestControllerJson {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/documentoPorID")
    @ResponseBody
    public Documento buscarDocId(){
        return documentoService.findOne(105);
    }
    @PostMapping("/documentoPorID")
    @ResponseBody
    public Documento postBuscarDocId(@RequestParam("id") String id){
        return documentoService.findOne(Integer.parseInt(id));
    }
}
