package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.CategoriaModel;
import pe.edu.idat.proyecto_bdsaire.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("categoria", new CategoriaModel());
        return "categorias/index";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute CategoriaModel categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        CategoriaModel categoria = categoriaService.buscarPorId(id).orElse(null);

        if (categoria == null) {
            return "redirect:/categorias";
        }

        model.addAttribute("categoria", categoria);
        return "categorias/edit";
    }

    @PostMapping("/update")
    public String actualizar(@ModelAttribute CategoriaModel categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return "redirect:/categorias";
    }
}