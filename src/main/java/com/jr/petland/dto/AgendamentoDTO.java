package com.jr.petland.dto;

import com.jr.petland.entities.Agendamento;
import com.jr.petland.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    private Long id;
    private LocalDateTime dataHora;
    private StatusAgendamento statusAgendamento;
    private BigDecimal valorTotal;
    private Long animalId;
    private String nomeAnimal;
    private Long servicoId;
    private String descricaoServico;

    public AgendamentoDTO(Agendamento agendamento){
        this.id = agendamento.getId();
        this.dataHora = agendamento.getDataHora();
        this.statusAgendamento = agendamento.getStatusAgendamento();
        this.valorTotal = agendamento.getValorTotal();
        this.animalId = agendamento.getAnimal().getId();
        this.nomeAnimal = agendamento.getAnimal().getNome();
        this.servicoId = agendamento.getServico().getId();
        this.descricaoServico = agendamento.getServico().getDescricao();
    }
}
