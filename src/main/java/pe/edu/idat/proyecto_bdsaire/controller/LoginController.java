package pe.edu.idat.proyecto_bdsaire.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.proyecto_bdsaire.model.LoginModel;
import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String frmLogin(Model model){
        model.addAttribute("loginmodel", new LoginModel());
        return "login";
    }

    @PostMapping("/logincontrol")
    public String login(@ModelAttribute("loginmodel") LoginModel loginModel,
                        Model model,
                        HttpSession session) {

        UsuarioModel usuario = usuarioRepository.findById(loginModel.getUsuario()).orElse(null);

        if (usuario == null || !usuario.getContrasena().equals(loginModel.getContraseña())) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }

        session.setAttribute("usuario", usuario);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}