package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.EntradasModel;
import pe.edu.idat.proyecto_bdsaire.repository.ProductoRepository;
import pe.edu.idat.proyecto_bdsaire.repository.ProveedorRepository;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;
import pe.edu.idat.proyecto_bdsaire.service.EntradasService;

import java.time.LocalDate;

@Controller
@RequestMapping("/entradas")
public class EntradasController {

    @Autowired
    private EntradasService entradasService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        model.addAttribute("entradas", entradasService.obtenerEntradas());
        model.addAttribute("entrada", new EntradasModel());

        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());

        return "entradas/index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("productoId") Integer productoId,
                       @RequestParam("proveedorId") Integer proveedorId,
                       @RequestParam("usuarioId") String usuarioId,
                       @RequestParam("cantidad") Integer cantidad) {

        EntradasModel entrada = new EntradasModel();
        entrada.setProducto(productoRepository.findById(productoId).orElse(null));
        entrada.setProveedor(proveedorRepository.findById(proveedorId).orElse(null));
        entrada.setUsuario(usuarioRepository.findById(usuarioId).orElse(null));
        entrada.setCantidad(cantidad);
        entrada.setFecha(LocalDate.now());

        entradasService.guardarEntradas(entrada);

        return "redirect:/entradas";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        EntradasModel entrada = entradasService.obtenerPorId(id).orElse(null);
        model.addAttribute("entrada", entrada);
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "entradas/edit";
    }

    @PostMapping("/update")
    public String actualizar(@ModelAttribute EntradasModel entrada,
                             @RequestParam("productoId") Integer productoId,
                             @RequestParam("proveedorId") Integer proveedorId,
                             @RequestParam("usuarioId") String usuarioId) {

        EntradasModel entradaExistente = entradasService.obtenerPorId(entrada.getEntradaid())
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada"));

        entradaExistente.setProducto(productoRepository.findById(productoId).orElse(null));
        entradaExistente.setProveedor(proveedorRepository.findById(proveedorId).orElse(null));
        entradaExistente.setUsuario(usuarioRepository.findById(usuarioId).orElse(null));
        entradaExistente.setCantidad(entrada.getCantidad());
        entradaExistente.setFecha(entrada.getFecha());

        entradasService.guardarEntradas(entradaExistente);
        return "redirect:/entradas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        entradasService.obtenerPorId(id).ifPresent(e -> entradasService.guardarEntradas(null));
        return "redirect:/entradas";
    }
}