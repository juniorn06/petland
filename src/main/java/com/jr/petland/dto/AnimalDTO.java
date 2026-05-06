package com.jr.petland.dto;

import com.jr.petland.entities.Animal;
import com.jr.petland.enums.Sexo;
import com.jr.petland.enums.TipoAnimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {

    private Long id;

    private TipoAnimal tipoAnimal;

    @NotBlank(message = "O nome é obrigatório")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O nome não pode conter caracteres especiais")
    private String nome;

    private Sexo sexo;

    private LocalDate dataNascimento;

    private String raca;

    @Positive(message = "O peso deve ser maior que zero")
    private Double peso;

    private LocalDateTime dataCadastro;

    private Long clienteId;


    public AnimalDTO(Animal animal){
        id = animal.getId();

        tipoAnimal = animal.getTipoAnimal();

        nome = animal.getNome();

        sexo = animal.getSexo();

        dataNascimento = animal.getDataNascimento();

        raca = animal.getRaca();

        peso =  animal.getPeso();

        dataCadastro = animal.getDataCadastro();

        clienteId = animal.getDono().getId();
    }
}
