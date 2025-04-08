package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.idat.proyecto_bdsaire.model.DetallePedidoModel;
import pe.edu.idat.proyecto_bdsaire.model.ProductoModel;
import pe.edu.idat.proyecto_bdsaire.repository.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        long totalProductos = productoRepository.count();
        long totalClientes = clienteRepository.count();
        long totalProveedores = proveedorRepository.count();
        long totalPedidos = detallePedidoRepository.count(); // si cada detalle representa un pedido

        List<DetallePedidoModel> ultimosPedidos = detallePedidoRepository.findTop5ByOrderByIdDesc();
        List<ProductoModel> bajoStock = productoRepository.findProductosConBajoStock(); // o el límite que prefieras

        model.addAttribute("totalProductos", totalProductos);
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("totalProveedores", totalProveedores);
        model.addAttribute("totalPedidos", totalPedidos);
        model.addAttribute("ultimosPedidos", ultimosPedidos);
        model.addAttribute("bajoStock", bajoStock);

        return "home";
    }
}