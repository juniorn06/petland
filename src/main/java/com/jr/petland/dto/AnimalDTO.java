package com.jr.petland.dto;

import com.jr.petland.entities.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {

    private Long id;
    private String tipo;
    private String nome;
    private String sexo;
    private Integer idade;
    private String raca;

    public AnimalDTO(Animal animal){
        id = animal.getId();
        tipo = animal.getTipo();
        nome = animal.getNome();
        sexo = animal.getSexo();
        idade = animal.getIdade();
        raca = animal.getRaca();
    }
}
