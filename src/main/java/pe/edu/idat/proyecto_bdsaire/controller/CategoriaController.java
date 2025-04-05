package pe.edu.idat.proyecto_bdsaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {
    @GetMapping("/categoria")
    public String categorias(){
        return "categoria";
    }
}
