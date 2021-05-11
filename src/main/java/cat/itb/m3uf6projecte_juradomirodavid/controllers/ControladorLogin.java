package cat.itb.m3uf6projecte_juradomirodavid.controllers;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Usuari;
import cat.itb.m3uf6projecte_juradomirodavid.model.repository.RepositoriUsuaris;
import cat.itb.m3uf6projecte_juradomirodavid.model.service.MyUserDetailsService;
import cat.itb.m3uf6projecte_juradomirodavid.model.service.ServeiUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {

    @Autowired
    private ServeiUsuari service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login_error")
    public String loginError() {
        return "login_error";
    }

    @GetMapping("/register")
    public String register(Model m) {
        m.addAttribute("userForm", new Usuari());
        return "register";
    }

    @PostMapping("/register")
    public String afegirUserSubmit(@ModelAttribute("userForm") Usuari user) {
        service.afegirUsuari(user);
        return "redirect:/login";
    }
}
