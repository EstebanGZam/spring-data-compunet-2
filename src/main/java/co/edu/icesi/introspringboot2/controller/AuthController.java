package co.edu.icesi.introspringboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Muestra el formulario de login (Spring Security ya maneja el POST /login)
    @GetMapping("/login")
    public String showLoginForm(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Email o contraseña incorrectos.");
        }
        if (logout != null) {
            model.addAttribute("message", "Has cerrado sesión correctamente.");
        }
        return "login";
    }


    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        return "home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";
    }
}
