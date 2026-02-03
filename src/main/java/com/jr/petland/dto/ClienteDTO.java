package com.jr.petland.dto;

import com.jr.petland.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Integer id;
    @NotBlank(message = "O campo nome é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O nome não pode conter caracteres especiais!")
    private String nome;
    @NotBlank(message = "O endereço é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O endereço não pode conter caracteres especiais!")
    private String endereco;
    @NotBlank(message = "O campo CPF é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O cpf não pode conter caracteres especiais!")
    private String cpf;
    @NotBlank(message = "O campo cidade é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "A cidade não pode conter caracteres especiais")
    private String cidade;
    private String email;

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        cpf = cliente.getCpf();
        cidade = cliente.getCidade();
        email = cliente.getEmail();
    }
}
