package com.jr.petland.entities;

import com.jr.petland.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    @NotNull(message = "O agendamento deve ter data e horário!")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_agendamento")
    @NotNull(message = "O agendamento deve ter um status definido!")
    private StatusAgendamento statusAgendamento;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    @NotNull(message = "O agendamento deve ter um animal vinculado!")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    @NotNull(message = "O agendamento deve ter um serviço vinculado!")
    private Servico servico;
}
