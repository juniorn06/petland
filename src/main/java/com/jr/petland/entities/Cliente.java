package com.jr.petland.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @NotBlank @CPF
    @Column(name = "cpf")
    private String cpf;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animais = new ArrayList<>();

    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
        animal.setDono(this);
    }
}
