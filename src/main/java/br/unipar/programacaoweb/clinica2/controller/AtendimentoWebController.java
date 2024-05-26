package br.unipar.programacaoweb.clinica2.controller;

import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AtendimentoWebController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/atendimentos/retornar")
    public String retornar(){ return "redirect:/home";}

    @GetMapping("/atendimentos")
    public String getMedicos(Model model) {
        List<Medico> medicos = medicoService.getAll();
        model.addAttribute("medicos", medicos);

        List<Paciente> pacientes = pacienteService.getAll();
        model.addAttribute("pacientes", pacientes);
        return "atendimentos"; // Nome do template Thymeleaf
    }

    @PostMapping("/atendimentos/save")
    public String processForm(@RequestParam("nomeCliente") String nomeCliente, @RequestParam("nomeMedico") String nomeMedico, @RequestParam("dataHora") String dataHora, Model model) {
        atendimentoService.save(nomeMedico, nomeMedico, dataHora);
        return "redirect:/atendimentos";
    }
}
