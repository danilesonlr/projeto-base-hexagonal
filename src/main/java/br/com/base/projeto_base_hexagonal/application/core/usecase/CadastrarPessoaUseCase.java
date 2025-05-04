package br.com.base.projeto_base_hexagonal.application.core.usecase;


import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;

public interface CadastrarPessoaUseCase {
    void salvar(Pessoa input);
}
