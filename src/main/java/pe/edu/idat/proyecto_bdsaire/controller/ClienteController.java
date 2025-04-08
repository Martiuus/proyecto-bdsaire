package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.ClienteModel;
import pe.edu.idat.proyecto_bdsaire.repository.ClienteRepository;
import pe.edu.idat.proyecto_bdsaire.service.ClienteService;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login"; // Redirige si no ha iniciado sesión
        }

        List<ClienteModel> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new ClienteModel());
        return "cliente/index";
    }

    @PostMapping("/save")
    public String guardarCliente(@ModelAttribute("cliente") ClienteModel cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String editarCliente(@PathVariable("id") Integer id, Model model) {
        ClienteModel cliente = clienteRepository.findById(id).orElse(null);

        if (cliente == null) {
            model.addAttribute("error", "El cliente con ID " + id + " no existe.");
            return "redirect:/clientes";
        }

        model.addAttribute("cliente", cliente);
        return "cliente/edit";
    }

    @PostMapping("/update")
    public String actualizarCliente(@ModelAttribute ClienteModel clienteModel, Model model) {
        if (!clienteRepository.existsById(clienteModel.getClienteid())) {
            model.addAttribute("error", "No se pudo actualizar porque el cliente no existe.");
            return "cliente/edit";
        }

        clienteRepository.save(clienteModel);
        return "redirect:/clientes";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}
