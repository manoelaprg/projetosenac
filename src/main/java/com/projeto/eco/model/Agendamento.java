package com.projeto.eco.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Entity
@Table(name = "Agendamento")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;
    private int hora;
    private String eco;
    private String medico;

    @ManyToOne
    @JoinColumn(name = "paciente_nome")   
    private Paciente paciente;
}
