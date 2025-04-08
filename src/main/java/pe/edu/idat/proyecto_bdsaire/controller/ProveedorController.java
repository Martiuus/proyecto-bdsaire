package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.ProveedorModel;
import pe.edu.idat.proyecto_bdsaire.repository.ProveedorRepository;
import pe.edu.idat.proyecto_bdsaire.service.ProveedorService;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;
    private final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorService proveedorService, ProveedorRepository proveedorRepository) {
        this.proveedorService = proveedorService;
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        List<ProveedorModel> proveedores = proveedorRepository.findAll();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedor", new ProveedorModel());
        return "proveedor/index";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("proveedor") ProveedorModel proveedor) {
        proveedorRepository.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        ProveedorModel proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor == null) {
            model.addAttribute("error", "Proveedor no encontrado");
            return "redirect:/proveedores";
        }
        model.addAttribute("proveedor", proveedor);
        return "proveedor/edit";
    }

    @PostMapping("/update")
    public String actualizar(@ModelAttribute("proveedor") ProveedorModel proveedor) {
        proveedorRepository.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        proveedorRepository.deleteById(id);
        return "redirect:/proveedores";
    }
}