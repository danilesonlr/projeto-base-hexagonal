package br.com.base.projeto_base_hexagonal.application.core.usecase.impl;


import br.com.base.projeto_base_hexagonal.application.core.usecase.DeletarPessoaUseCase;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;

public class DeletarPessoaUseCaseImpl implements DeletarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;

    public DeletarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
       this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deletarPorId(id);
    }
}
