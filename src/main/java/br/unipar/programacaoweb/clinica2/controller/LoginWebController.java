package br.unipar.programacaoweb.clinica2.controller;

import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//response body
@Controller
public class LoginWebController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){
        Usuario usuario = usuarioService.validarUsuario(username, password);
        if( usuario != null){
            session.setAttribute("UsuarioLogado", username);
            return "redirect:/home";
        }else{
            model.addAttribute("erro", "Usuário ou Senha inválidos!");
            return "login";
        }
    }

    @PostMapping("/cadastrarUsuarios")
    public String cadastrarUsuarios(){ return "redirect:/usuarios";}

}
