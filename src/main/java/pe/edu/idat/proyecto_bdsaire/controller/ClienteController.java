package pe.edu.idat.proyecto_bdsaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @GetMapping("/clientes")
    public String cliente(){
        return "clientes";
    }
}
