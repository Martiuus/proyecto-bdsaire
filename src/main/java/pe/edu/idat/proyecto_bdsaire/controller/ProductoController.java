package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.ProductoModel;
import pe.edu.idat.proyecto_bdsaire.repository.CategoriaRepository;
import pe.edu.idat.proyecto_bdsaire.repository.ProveedorRepository;
import pe.edu.idat.proyecto_bdsaire.repository.UbicacionRepository;
import pe.edu.idat.proyecto_bdsaire.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("producto", new ProductoModel());
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        model.addAttribute("ubicaciones", ubicacionRepository.findAll());
        return "productos/index";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("producto") ProductoModel producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        ProductoModel producto = productoService.obtenerPorId(id).orElse(null);
        if (producto == null) {
            return "redirect:/productos";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        model.addAttribute("ubicaciones", ubicacionRepository.findAll());

        return "productos/edit";
    }

    @PostMapping("/update")
    public String actualizar(@ModelAttribute ProductoModel producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}