package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String index(Model model, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!"admin".equals(usuario.getRol().name())) {
            return "redirect:/home";
        }

        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new UsuarioModel());
        return "usuarios/index";
    }

    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute("usuario") UsuarioModel usuario, HttpSession session) {
        UsuarioModel user = (UsuarioModel) session.getAttribute("usuario");
        if (user == null || !"admin".equals(user.getRol().name())) {
            return "redirect:/login";
        }

        String ultimoId = usuarioRepository.findUltimoId();
        int nuevoNumero = 1;

        if (ultimoId != null && ultimoId.startsWith("PE")) {
            nuevoNumero = Integer.parseInt(ultimoId.substring(2)) + 3;
        }

        String nuevoId = String.format("PE%05d", nuevoNumero);
        usuario.setUsuarioid(nuevoId);
        usuario.setFechacreacion(LocalDateTime.now());

        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String editarUsuario(@PathVariable("id") String id, Model model, HttpSession session) {
        UsuarioModel user = (UsuarioModel) session.getAttribute("usuario");
        if (user == null || !"admin".equals(user.getRol().name())) {
            return "redirect:/login";
        }

        UsuarioModel usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);
        return "usuarios/edit";
    }

    @PostMapping("/update")
    public String actualizarUsuario(@ModelAttribute UsuarioModel usuario, HttpSession session) {
        UsuarioModel user = (UsuarioModel) session.getAttribute("usuario");
        if (user == null || !"admin".equals(user.getRol().name())) {
            return "redirect:/login";
        }

        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") String id, HttpSession session) {
        UsuarioModel user = (UsuarioModel) session.getAttribute("usuario");
        if (user == null || !"admin".equals(user.getRol().name())) {
            return "redirect:/login";
        }

        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}
