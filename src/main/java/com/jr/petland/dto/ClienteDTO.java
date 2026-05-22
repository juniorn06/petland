package com.jr.petland.dto;

import com.jr.petland.entities.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O nome não pode conter caracteres especiais!")
    private String nome;

    @NotBlank(message = "O campo endereço é obrigatório!")
    private String endereco;

    @NotBlank(message = "O campo bairro é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O campo bairro não pode conter caracteres especiais!")
    private String bairro;

    @NotBlank(message = "O campo cidade é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O campo cidade não pode conter caracteres especiais")
    private String cidade;

    @CPF
    @NotBlank(message = "O campo CPF é obrigatório!")
    private String cpf;

    @Email
    private String email;
    
    private String telefone;

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        bairro = cliente.getBairro();
        cidade = cliente.getCidade();
        cpf = cliente.getCpf();
        email = cliente.getEmail();
        telefone = cliente.getTelefone();
    }
}
