package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.model.dao.IDocumentoDao;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.FuncionarioService;

import javax.servlet.http.HttpSession;

@Controller
public class ConsultaPermisoController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/consultaPermiso")
    public String formularioP(Model model, HttpSession session){

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona")== null){
            return "redirect:/dashboard";
        }
        Funcionario funcionario = (Funcionario) session.getAttribute("funcionario");
        System.out.println(documentoService.findAllByFuncionarioId(funcionario).size());
        model.addAttribute("listaDocumento",documentoService.findAllByFuncionarioId(funcionario));



        return "consultaPermiso";
    }

}