package com.projeto.eco.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name = "Paciente")
@Component

public class Paciente {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Date datanascimento;
    private String cpf;    

}
