package com.jr.petland.dto;

import com.jr.petland.entities.Animal;
import com.jr.petland.enums.Sexo;
import com.jr.petland.enums.TipoAnimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {

    private Long id;
    private TipoAnimal tipoAnimal;
    private String nome;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String raca;

    public AnimalDTO(Animal animal){
        id = animal.getId();
        tipoAnimal = animal.getTipoAnimal();
        nome = animal.getNome();
        sexo = animal.getSexo();
        dataNascimento = animal.getDataNascimento();
        raca = animal.getRaca();
    }
}
