package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.FuncionarioService;

import javax.servlet.http.HttpSession;

@Controller
public class Dashboard {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ConsultaControlAccesoServicio consultaControlAccesoServicio;

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, HttpSession httpSession, Model model){
        //Validación de session para evitar error de atributo null
        if(authentication.getName()== null){

            return "redirect:/login";
        }
        int rut = Integer.parseInt(authentication.getName());

        Persona persona = consultaControlAccesoServicio.busquedaPorRut(rut);
        Funcionario funcionario = funcionarioService.buscarPorRut(rut);
        httpSession.setAttribute("persona" ,persona);
        httpSession.setAttribute("funcionario",funcionario);


        if (funcionario.getRolId().getNombre().toUpperCase().equals("FUNCIONARIO")||funcionario.getRolId().getNombre().toUpperCase().equals("ADMINISTRADOR")){
            model.addAttribute("listadoPermisos",documentoService.findAllByFuncionarioIdAndMotivoId(funcionario));
        }

        return "dashboard";
    }
}
