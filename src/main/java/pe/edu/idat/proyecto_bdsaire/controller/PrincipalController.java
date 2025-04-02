package pe.edu.idat.proyecto_bdsaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.proyecto_bdsaire.model.LoginModel;

@Controller
public class PrincipalController {

    @GetMapping("/login")
    public String frmLogin(Model model){
        model.addAttribute("loginmodel", new LoginModel());
        return "login";
    }

    @PostMapping("/logincontrol")
    public String login(@ModelAttribute("loginmodel") LoginModel loginModel, Model model) {
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";

        if (loginModel.getUsuario().equals(usuarioCorrecto) && loginModel.getContraseña().equals(contraseñaCorrecta)) {
            return "redirect:/home"; // Si las credenciales son correctas, va al home
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login"; // Vuelve al login con un mensaje de error
        }
    }

}
