package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private  String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private  String textoListar;
    @GetMapping({"/","/index","/home"})
    public String index(Model model){
        model.addAttribute("titulo",textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario= new Usuario();
        usuario.setNombre("Gustavo");
        usuario.setApellido("Santana");
        usuario.setEmail("gus@gmail.com");

        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        /*
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose","Lavarez","Arriaga@gmail.com"));
        usuarios.add(new Usuario("Laura","Rios","Robles@gmail.com"));
        usuarios.add(new Usuario("Benito","Solar","Quirioz@gmail.com"));
        */

        /*
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Jose","Lavarez","Arriaga@gmail.com"),
                new Usuario("Laura","Rios","Robles@gmail.com"),
                new Usuario("Benito","Solar","Quirioz@gmail.com"),
                new Usuario("Laura","Lios","liios@gmail.com"));

       model.addAttribute("titulo","Listado de usuarios");
        model.addAttribute("usuarios",usuarios);

         */
        model.addAttribute("titulo",textoListar);
        return "listar";
    }


    /* Usar un objeto en comun para todos las vistas y los procesos usando
    * el model para trabajar */
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Jose","Lavarez","Arriaga@gmail.com"),
                new Usuario("Laura","Rios","Robles@gmail.com"),
                new Usuario("Benito","Solar","Quirioz@gmail.com"),
                new Usuario("Laura","Lios","liios@gmail.com"));

        return usuarios;
    }



    /*

    @GetMapping({"/","/index","/home"})
    public String index(Map<String,Object> map){
        map.put("titulo","Hola spring es lo que mando map");
        return "index";
    }

    @GetMapping({"/","/index","/home"})
    public ModelAndView index(ModelAndView mv){
        mv.addObject("titulo","Hola spring es lo que mando mv");
        mv.setViewName("index");
        return mv;
    }
    */
}

