package br.com.base.projeto_base_hexagonal.application.core.usecase.impl;


import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.core.usecase.BuscarPessoaUseCase;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;

public class BuscarPessoaUseCaseImpl implements BuscarPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;

    public BuscarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.buscarPorId(id);
    }
}
