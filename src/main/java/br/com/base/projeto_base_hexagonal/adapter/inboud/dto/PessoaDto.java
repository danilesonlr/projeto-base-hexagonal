package br.com.base.projeto_base_hexagonal.adapter.inboud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDto {
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private LocalDate dateNascimento;
    @NotNull
    private String telefone;
    @NotNull
    private String cep;
}
