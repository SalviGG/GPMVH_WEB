package portafolio.gpvh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import portafolio.gpvh.controlAccesoWS.mappingWsl.Persona;
import portafolio.gpvh.controlAccesoWS.service.ConsultaControlAccesoServicio;
import portafolio.gpvh.model.entity.Documento;
import portafolio.gpvh.model.entity.Funcionario;
import portafolio.gpvh.model.service.DocumentoService;
import portafolio.gpvh.model.service.FuncionarioService;
import portafolio.gpvh.model.service.ResolucionService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Dashboard {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ConsultaControlAccesoServicio consultaControlAccesoServicio;

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private ResolucionService resolucionService;

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


        if (funcionario.getRolId().getNombre().toUpperCase().equals("FUNCIONARIO")||funcionario.getRolId().getNombre().toUpperCase().equals("ADMINISTRADOR")
                ||funcionario.getRolId().getNombre().toUpperCase().equals("JEFE INTERNO")){

            model.addAttribute("listadoPermisos",documentoService.findAllByFuncionarioIdAndMotivoId(funcionario));

        }else if (funcionario.getRolId().getNombre().toUpperCase().equals("JEFE SUPERIOR")||funcionario.getRolId().getNombre().toUpperCase().equals("ALCALDE")||
                    funcionario.getRolId().getNombre().toUpperCase().equals("RRHH")){

            model.addAttribute("cantidadPermisos", documentoService.countDocumentos());
            model.addAttribute("cantidadResoluciones",resolucionService.countResoluciones());
            model.addAttribute("permisosRevision", documentoService.countDocumentosRevision());
            model.addAttribute("permisosTodos", documentoService.countDocumentosAll());
            if (funcionario.getRolId().getNombre().toUpperCase().equals("RRHH")){
                List<Documento> ultimosPremisosRevision = new ArrayList<Documento>();
                for (int i = 0; i <= 4 ; i++) {
                    if (documentoService.findUltimosConDocumento().size()>i){
                        ultimosPremisosRevision.add(documentoService.findUltimosConDocumento().get(i));
                    }else{
                        break;
                    }
                }
                model.addAttribute("ultimosPermisosRevision", ultimosPremisosRevision);
            }else{
                List<Documento> ultimosPremisos = new ArrayList<Documento>();
                for (int i = 0; i <= 4 ; i++) {
                    if (documentoService.findUltimosPermisos().size()>i){
                        ultimosPremisos.add(documentoService.findUltimosPermisos().get(i));
                    }else{
                        break;
                    }
                }
                model.addAttribute("ultimosPermisos", ultimosPremisos);
            }
        }


        return "dashboard";
    }
}
