package br.unipar.programacaoweb.clinica2.service;

import br.unipar.programacaoweb.clinica2.model.Medico;
import br.unipar.programacaoweb.clinica2.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getAll(){
        return this.medicoRepository.findAll();
    }

    public Medico save(Medico medico){return this.medicoRepository.save(medico);}

    public String validarNomeDisponivel(String nome) {
        Medico medicoExistente = medicoRepository.findByNome(nome);
        if (medicoExistente != null) {
            return "Nome já em uso, tente outro!";
        }
        return null;
    }
}
