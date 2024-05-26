package br.unipar.programacaoweb.clinica2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeWebController {

    @PostMapping("/cadastrarMedicos")
    public String abrirCadastroMedicos(){return "redirect:/medicos";}

    @PostMapping("/cadastrarPacientes")
    public String abrirCadastroPacientes(){return "redirect:/pacientes";}

    @PostMapping("/cadastrarAtendimentos")
    public String abrirCadastroAtendimentos(){return "redirect:/atendimentos";}
}