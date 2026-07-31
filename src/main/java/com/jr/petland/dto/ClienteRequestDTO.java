package com.jr.petland.dto;

import com.jr.petland.entities.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    private Long id;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O nome não pode conter caracteres especiais!")
    private String nome;

    @NotBlank(message = "O campo endereço é obrigatório!")
    private String endereco;

    @NotBlank(message = "O campo bairro é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9 ]+$", message = "O campo bairro não pode conter caracteres especiais!")
    private String bairro;

    @NotBlank(message = "O campo cidade é obrigatório!")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9 ]+$", message = "O campo cidade não pode conter caracteres especiais!")
    private String cidade;

    @CPF(message = "O CPF informado é invaido!")
    @NotBlank(message = "O campo CPF é obrigatório!")
    private String cpf;

    @Email(message = "O email informado não é válido!")
    private String email;

    @NotBlank(message = "O campo telefone é obrigatório!")
    @Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$", message = "O telefone informado não é válido!")
    private String telefone;
}
