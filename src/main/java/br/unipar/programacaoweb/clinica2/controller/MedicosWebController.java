package br.unipar.programacaoweb.clinica2.controller;

import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedicosWebController {

    @Autowired
    private final MedicoService medicoService;

    public MedicosWebController(MedicoService medicoService) {this.medicoService = medicoService;
    }

    @PostMapping("/medicos/retornar")
    public String retornar(){ return "redirect:/home";}

    @GetMapping(path = "/medicos")
    public String getAllMedicos(Model model){
        List<Medico> medicos = medicoService.getAll();
        model.addAttribute("medicos", medicos);
        return "medicos";
    }

    @PostMapping(path = "medicos/save")
    public String saveMedico(Medico medico, @RequestParam("nome") String nome, Model model) {
        String erro = medicoService.validarNomeDisponivel(nome);
        if (erro != null) {
            model.addAttribute("erro", "Nome já disponível!");
            return "redirect:/medicos";
        } else {
            medicoService.save(medico);
            return "redirect:/medicos";
        }
    }

}
