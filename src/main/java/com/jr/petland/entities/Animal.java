package com.jr.petland.entities;

import com.jr.petland.enums.Sexo;
import com.jr.petland.enums.TipoAnimal;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private TipoAnimal tipoAnimal;
    private String nome;
    private Sexo sexo;
    private Date dataNascimento;
    private String raca;
}
