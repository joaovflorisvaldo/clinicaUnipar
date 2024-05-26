package br.unipar.programacaoweb.clinica2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Atendimento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pkPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "pkMedico")
    private Medico medico;

    private String data_hora;

}
