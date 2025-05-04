package br.com.base.projeto_base_hexagonal.application.core.usecase.impl;

import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.core.usecase.BuscarTodosPessoaUseCase;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;


import java.util.List;

public class BuscarTodosPessoaUseCaseImpl implements BuscarTodosPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;


    public BuscarTodosPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.buscarTodos();
    }
}
