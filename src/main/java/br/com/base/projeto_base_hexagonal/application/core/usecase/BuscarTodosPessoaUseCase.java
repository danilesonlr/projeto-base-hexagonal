package br.com.base.projeto_base_hexagonal.application.core.usecase;


import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;

import java.util.List;

public interface BuscarTodosPessoaUseCase {
    List<Pessoa> buscarTodos();
}
