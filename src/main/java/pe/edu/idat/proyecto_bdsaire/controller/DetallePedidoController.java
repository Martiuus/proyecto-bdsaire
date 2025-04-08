package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.DetallePedidoModel;
import pe.edu.idat.proyecto_bdsaire.repository.OrdenFinalRepository;
import pe.edu.idat.proyecto_bdsaire.repository.ProductoRepository;
import pe.edu.idat.proyecto_bdsaire.service.DetallePedidoService;

import java.util.List;

@Controller
@RequestMapping("/detallepedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private OrdenFinalRepository ordenFinalRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        List<DetallePedidoModel> detalles = detallePedidoService.obtenerDetalles();
        model.addAttribute("detalles", detalles);
        model.addAttribute("detalle", new DetallePedidoModel());
        model.addAttribute("ordenes", ordenFinalRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        return "ordendeventa/detallepedido/index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DetallePedidoModel detalle) {
        double subtotal = detalle.getCantidad() * detalle.getPrecio();
        detalle.setSubtotal(subtotal);
        detallePedidoService.guardar(detalle);
        return "redirect:/detallepedido";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        DetallePedidoModel detalle = detallePedidoService.obtenerPorId(id).orElse(null);
        model.addAttribute("detalle", detalle);
        model.addAttribute("ordenes", ordenFinalRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        return "ordendeventa/detallepedido/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute DetallePedidoModel detalle) {
        double subtotal = detalle.getCantidad() * detalle.getPrecio();
        detalle.setSubtotal(subtotal);
        detallePedidoService.guardar(detalle);
        return "redirect:/detallepedido";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detallePedidoService.eliminar(id);
        return "redirect:/detallepedido";
    }
}