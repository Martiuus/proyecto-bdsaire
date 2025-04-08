package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.SalidaModel;
import pe.edu.idat.proyecto_bdsaire.model.Motivo;
import pe.edu.idat.proyecto_bdsaire.repository.ProductoRepository;
import pe.edu.idat.proyecto_bdsaire.repository.SalidaRepository;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    private SalidaRepository salidaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        model.addAttribute("salidas", salidaRepository.findAll());
        model.addAttribute("salida", new SalidaModel());
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("motivos", Motivo.values());
        return "salidas/index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("producto") Integer productoId,
                       @RequestParam("usuario") String usuarioId,
                       @RequestParam("motivo") Motivo motivo,
                       @RequestParam("cantidad") Integer cantidad) {

        SalidaModel salida = new SalidaModel();
        salida.setProducto(productoRepository.findById(productoId).orElse(null));
        salida.setUsuario(usuarioRepository.findById(usuarioId).orElse(null));
        salida.setMotivo(motivo);
        salida.setCantidad(cantidad);
        salida.setFecha(LocalDate.now());

        salidaRepository.save(salida);
        return "redirect:/salidas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        SalidaModel salida = salidaRepository.findById(id).orElse(null);
        model.addAttribute("salida", salida);
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("motivos", Motivo.values());
        return "salidas/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("salida") SalidaModel salida,
                         @RequestParam("productoId") Integer productoId,
                         @RequestParam("usuarioId") String usuarioId) {

        SalidaModel salidaExistente = salidaRepository.findById(salida.getSalidaid())
                .orElseThrow(() -> new RuntimeException("Salida no encontrada"));

        salidaExistente.setProducto(productoRepository.findById(productoId).orElse(null));
        salidaExistente.setUsuario(usuarioRepository.findById(usuarioId).orElse(null));
        salidaExistente.setMotivo(salida.getMotivo());
        salidaExistente.setCantidad(salida.getCantidad());
        salidaExistente.setFecha(salida.getFecha());

        salidaRepository.save(salidaExistente);
        return "redirect:/salidas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        salidaRepository.deleteById(id);
        return "redirect:/salidas";
    }
}