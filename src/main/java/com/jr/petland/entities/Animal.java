package com.jr.petland.entities;

import com.jr.petland.enums.Sexo;
import com.jr.petland.enums.TipoAnimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TIPO_ANIMAL")
    private TipoAnimal tipoAnimal;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SEXO")
    private Sexo sexo;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "RACA")
    private String raca;
}
