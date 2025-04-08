package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.ClienteModel;
import pe.edu.idat.proyecto_bdsaire.model.EstadoOrden;
import pe.edu.idat.proyecto_bdsaire.model.OrdenFinalModel;
import pe.edu.idat.proyecto_bdsaire.repository.ClienteRepository;
import pe.edu.idat.proyecto_bdsaire.repository.OrdenFinalRepository;
import pe.edu.idat.proyecto_bdsaire.service.OrdenFinalService;

import java.util.Optional;

@Controller
@RequestMapping("/ordenfinal")
public class OrdenFinalController {
    @Autowired
    private final OrdenFinalService ordenFinalService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdenFinalRepository ordenFinalRepository;

    public OrdenFinalController(OrdenFinalService ordenFinalService) {
        this.ordenFinalService = ordenFinalService;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        model.addAttribute("ordenfinal", new OrdenFinalModel());
        model.addAttribute("ordenes", ordenFinalRepository.findByEstadoNot(EstadoOrden.Cancelado));
        model.addAttribute("clientes", clienteRepository.findAll());
        return "ordendeventa/ordenfinal/index";
    }

    @PostMapping("/save")
    public String guardarOrdenFinal(
            @ModelAttribute("ordenfinal") OrdenFinalModel ordenfinal,
            BindingResult result,
            Model model
    ) {
        // Buscar cliente por ID
        Integer clienteId = ordenfinal.getCliente() != null ? ordenfinal.getCliente().getClienteid() : null;

        if (clienteId == null || !clienteRepository.existsById(clienteId)) {
            model.addAttribute("error", "El cliente ingresado no existe. Verifica el ID.");
            model.addAttribute("ordenfinal", ordenfinal);
            model.addAttribute("ordenes", ordenFinalRepository.findAll());
            return "ordendeventa/ordenfinal/index";
        }

        // Setear el cliente real
        ClienteModel cliente = clienteRepository.findById(clienteId).get();
        ordenfinal.setCliente(cliente);

        ordenFinalRepository.save(ordenfinal);
        return "redirect:/ordenfinal";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        OrdenFinalModel ordenFinalModel = ordenFinalService.obtenerOrdenFinalXid(id);

        if (ordenFinalModel != null) {
            model.addAttribute("ordenfinal", ordenFinalModel);
            model.addAttribute("clientes", clienteRepository.findAll());
            return "ordendeventa/ordenfinal/edit";
        } else {
            return "redirect:/ordenfinal";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String cancelarOrdenFinal(@PathVariable Integer id, Model model) {
        Optional<OrdenFinalModel> optionalOrden = ordenFinalRepository.findById(id);

        if (optionalOrden.isEmpty()) {
            model.addAttribute("error", "La orden con ID " + id + " no existe.");
            model.addAttribute("ordenes", ordenFinalRepository.findAll());
            model.addAttribute("ordenfinal", new OrdenFinalModel());
            return "ordendeventa/ordenfinal/index";
        }

        OrdenFinalModel orden = optionalOrden.get();
        orden.setEstado(EstadoOrden.Cancelado);
        ordenFinalRepository.save(orden);

        return "redirect:/ordenfinal";
    }

    @PostMapping("/update")
    public String actualizarOrdenFinal(@ModelAttribute("ordenfinal") OrdenFinalModel ordenFinalModel,
                                       @RequestParam("clienteid") Integer clienteId,
                                       @RequestParam("estado") EstadoOrden estado,
                                       Model model) {

        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isEmpty()) {
            model.addAttribute("error", "El cliente con ID " + clienteId + " no existe.");
            model.addAttribute("ordenfinal", ordenFinalModel);
            return "ordendeventa/ordenfinal/edit";
        }

        ClienteModel cliente = clienteOptional.get();
        ordenFinalModel.setCliente(cliente);
        ordenFinalModel.setEstado(estado);

        ordenFinalService.guardarOrdenFinal(ordenFinalModel);

        return "redirect:/ordenfinal";
    }
}
