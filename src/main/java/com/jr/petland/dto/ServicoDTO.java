package com.jr.petland.dto;

import com.jr.petland.entities.Cliente;
import com.jr.petland.entities.Servico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {

    private Long id;

    @NotBlank(message = "O campo descrição é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O nome não pode conter caracteres especiais!")
    private String descricao;

    @NotBlank(message = "O campo preço é obrigatório!")
    private BigDecimal preco;

    @NotBlank(message = "O campo tempo do serviço é obrigatório!")
    private Integer tempoServico;


    public ServicoDTO(Servico servico){
      id = servico.getId();
      descricao = servico.getDescricao();
      preco = servico.getPreco();
      tempoServico = servico.getTempoServico();

    }
}
