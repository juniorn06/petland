package com.jr.petland.dto;

import com.jr.petland.entities.Animal;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {

    @NotNull(message = "O campo data e hora é obrigatório!")
    private LocalDateTime dataHora;

    @NotNull(message = "O campo animal é obrigatório!")
    private Long animalId;

    @NotNull(message = "O campo serviço é obrigatório!")
    private Long servicoId;
}
