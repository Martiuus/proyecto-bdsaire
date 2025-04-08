package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.UbicacionModel;
import pe.edu.idat.proyecto_bdsaire.repository.UbicacionRepository;
import pe.edu.idat.proyecto_bdsaire.service.UbicacionService;

import java.util.List;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

    private final UbicacionService ubicacionService;
    private final UbicacionRepository ubicacionRepository;

    public UbicacionController(UbicacionService ubicacionService, UbicacionRepository ubicacionRepository) {
        this.ubicacionService = ubicacionService;
        this.ubicacionRepository = ubicacionRepository;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        List<UbicacionModel> ubicaciones = ubicacionRepository.findAll();
        model.addAttribute("ubicaciones", ubicaciones);
        model.addAttribute("ubicacion", new UbicacionModel());
        return "ubicacion/index";
    }

    @PostMapping("/save")
    public String guardarUbicacion(@ModelAttribute("ubicacion") UbicacionModel ubicacion) {
        ubicacionRepository.save(ubicacion);
        return "redirect:/ubicacion";
    }

    @GetMapping("/edit/{id}")
    public String editarUbicacion(@PathVariable("id") Integer id, Model model) {
        UbicacionModel ubicacion = ubicacionRepository.findById(id).orElse(null);

        if (ubicacion == null) {
            model.addAttribute("error", "La ubicación con ID " + id + " no existe.");
            return "redirect:/ubicacion";
        }

        model.addAttribute("ubicacion", ubicacion);
        return "ubicacion/edit";
    }

    @PostMapping("/update")
    public String actualizarUbicacion(@ModelAttribute UbicacionModel ubicacionModel, Model model) {
        if (!ubicacionRepository.existsById(ubicacionModel.getUbicacionid())) {
            model.addAttribute("error", "No se pudo actualizar porque la ubicación no existe.");
            return "ubicacion/edit";
        }

        ubicacionRepository.save(ubicacionModel);
        return "redirect:/ubicacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUbicacion(@PathVariable("id") Integer id) {
        ubicacionRepository.deleteById(id);
        return "redirect:/ubicacion";
    }
}
