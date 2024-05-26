package br.unipar.programacaoweb.clinica2.repository;

import br.unipar.programacaoweb.clinica2.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByNome(String nome);
}
