package br.com.base.projeto_base_hexagonal.application.port.out;


import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaDomainGateway {
    void salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> buscarTodos();
    void deletarPorId(Long id);
}
