package br.unipar.programacaoweb.clinica2.controller;

import br.unipar.programacaoweb.clinica2.model.Atendimento;
import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.model.Usuario;
import br.unipar.programacaoweb.clinica2.service.AtendimentoService;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import br.unipar.programacaoweb.clinica2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@Controller
public class AtendimentoWebController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private AtendimentoService atendimentoService;


    @PostMapping("/atendimentos/retornar")
    public String retornar(){ return "redirect:/home";}

    @GetMapping("/atendimentos")
    public String getMedicos(Model model) {
        List<Medico> medicos = medicoService.getAll();
        model.addAttribute("medicos", medicos);

        List<Paciente> pacientes = pacienteService.getAll();
        model.addAttribute("pacientes", pacientes);

        List<Atendimento> atendimentos = atendimentoService.getAll();
        model.addAttribute("atendimentos", atendimentos);

        return "atendimentos";
    }

    @PostMapping("atendimentos/save")
    public String saveAtendimento(@RequestParam("pkPaciente") Long pkPaciente, @RequestParam("pkMedico") Long pkMedico, @RequestParam("data_hora") String dataHora) {

        Paciente paciente = new Paciente();
        paciente.setId(pkPaciente);

        Medico medico = new Medico();
        medico.setId(pkMedico);

        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(paciente);
        atendimento.setMedico(medico);
        atendimento.setData_hora(dataHora);
        atendimentoService.save(atendimento);

        return "redirect:/atendimentos";
    }

}
