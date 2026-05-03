package com.jr.petland.entities;

import com.jr.petland.enums.Sexo;
import com.jr.petland.enums.TipoAnimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "animal")
public class  Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_ANIMAL")
    @NotNull
    private TipoAnimal tipoAnimal;

    @Column(name = "NOME")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @PastOrPresent(message = "A data de nascimento não pode ser futura")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "RACA")
    private String raca;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "observacoes")
    private String observacoes;

    @CreationTimestamp
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "O animal deve ter um dono")
    private Cliente dono;

    @Transient
    public String getIdadeFormatada(){
        if (this.dataNascimento == null){
            return "Data não cadastrada!";
        }

        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, hoje);

        return periodo.getYears() + " anos e " + periodo.getMonths() + "meses";
    }
}
