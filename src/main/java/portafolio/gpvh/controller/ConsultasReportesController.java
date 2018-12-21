package portafolio.gpvh.controller;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portafolio.gpvh.model.entity.*;
import portafolio.gpvh.model.service.*;
import portafolio.gpvh.objetos.ValidacionLogin;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsultasReportesController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EstadoDocumentoService estadoDocumentoService;

    @Autowired
    private MotivoService motivoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ResolucionService resolucionService;

    @GetMapping("/consultasReportes")
    public String consultaDeLosRepos(HttpSession session, Model model) {

        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";
        }

        return "consultasReportes";
    }

    @GetMapping("/consultaResoluciones")
    public String busquedaReportes(HttpSession session, Model model) {

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("listadoMotivo", motivoService.findAll());

        return "consultaResoluciones";
    }

    @PostMapping("/cosultaResoluciones")
    public String PostBusquedaResoluciones(HttpSession session, Model model, @RequestParam("busqueda") String busqueda,
                                           @RequestParam("inputText") String inputText,
                                           @RequestParam("motivo") String motivo) {

        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";
        }

        ValidacionLogin validador = new ValidacionLogin();

        if (busqueda.equals("seleccion")){
            String mensaje = "Debe seleccionar un parametro de busqueda";
            model.addAttribute("mensaje",mensaje);
            model.addAttribute("listadoMotivo", motivoService.findAll());

            return "consultaResoluciones";
        }else if (inputText == null || validador.tryParseInt(inputText) == false){

            String mensaje = "Ha ingresado un valor de busqueda no númerico, \n incorrecto o no ha ingresado valor";
            model.addAttribute("mensaje",mensaje);
            model.addAttribute("listadoMotivo", motivoService.findAll());

            return "consultaResoluciones";
        }

        if (busqueda.equals("motivo")) {
            Motivo motivoBuscado = motivoService.findOne(Integer.parseInt(motivo));
            model.addAttribute("busqueda", resolucionService.findByMotivoId(motivoBuscado));
            System.out.println(motivoBuscado.getNombre());
        } else if (busqueda.equals("rut")) {
            Funcionario funcionarioBusqueda = funcionarioService.buscarPorRut(Integer.parseInt(inputText.trim()));
            model.addAttribute("busqueda", resolucionService.findByFuncionarioId(funcionarioBusqueda));
            System.out.println();
        } else if (busqueda.equals("resId")) {
            System.out.println(inputText);
            Resolucion resolucionBusqueda = resolucionService.findOne(Integer.parseInt(inputText.trim()));
            List<Resolucion> reso = new ArrayList<Resolucion>();
            reso.add(resolucionBusqueda);
            model.addAttribute("busqueda", reso);
        }
       /* if (motivo!=null){
            Motivo motivoBuscado = motivoService.findOne(Integer.parseInt(motivo));
            model.addAttribute("busquedaMotivo", resolucionService.findByMotivoId(motivoBuscado));
        } else if (inputText!=null){
            Funcionario funcionarioBusqueda = funcionarioService.findOne(Integer.parseInt(inputText));
            model.addAttribute("busquedaRut", resolucionService.findByFuncionarioId(funcionarioBusqueda));
        }*/
        model.addAttribute("listadoMotivo", motivoService.findAll());


        return "consultaResoluciones";
    }


    @GetMapping("/informePermisos")
    public String busquedaInformes(HttpSession session, Model model) {

        //Validación de session para evitar error de atributo null
        if (session.getAttribute("persona") == null) {
            return "redirect:/dashboard";

        }
        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoDoc", estadoDocumentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());
        return "informePermisos";

    }

    @PostMapping("/infomePermisos")
    public String PostBusquedaInformes(Model model, @RequestParam("busqueda") String rut,
                                       @RequestParam("inputText") String inputText,
                                       @RequestParam("departamento") String departamento,
                                       @RequestParam("motivo") String motivo,
                                       @RequestParam("estado") String estado) {

        model.addAttribute("listadoDepto", departamentoService.findAll());
        model.addAttribute("listadoDoc", estadoDocumentoService.findAll());
        model.addAttribute("listadoMotivo", motivoService.findAll());

        System.out.println(inputText);
        System.out.println(departamento);
        System.out.println(motivo);
        System.out.println(estado);

        return "informePermisos";
    }
}
