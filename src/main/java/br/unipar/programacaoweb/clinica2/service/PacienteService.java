package br.unipar.programacaoweb.clinica2.service;

import br.unipar.programacaoweb.clinica2.model.Paciente;
import br.unipar.programacaoweb.clinica2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {

    @Autowired
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getAll(){return this.pacienteRepository.findAll();}

    public Paciente save(Paciente paciente){return this.pacienteRepository.save(paciente);}

    public String validarNomeDisponivel(String nome) {
        Paciente pacienteExistente = pacienteRepository.findByNome(nome);
        if (pacienteExistente != null) {
            return "Nome já em uso, tente outro!";
        }
        return null;
    }
}
