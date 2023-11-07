package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model){
        return "variables/index";
    }
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable(name = "texto") String texto, Model model){
        model.addAttribute("titulo","Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado","el textro enviado en la ruta es: "+texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable(name = "texto") String texto,@PathVariable(name = "numero") Integer numero, Model model){
        model.addAttribute("titulo","Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado","el textro enviado en la ruta es: "+texto +" y el numero enviado es "+numero);
        return "variables/ver";
    }
}
