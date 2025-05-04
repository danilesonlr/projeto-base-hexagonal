package br.com.base.projeto_base_hexagonal.application.core.usecase.impl;


import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.core.usecase.AlterarPessoaUseCase;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;

public class AlterarPessoaUseCaseImpl implements AlterarPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;

    public AlterarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void alterarPessoa(Pessoa input, Long id) {
        Pessoa atual = pessoaRepository.buscarPorId(id);

        atual.setNome(input.getNome());
        atual.setCpf(input.getCpf());
        atual.setDateNascimento(input.getDateNascimento());
        atual.setTelefone(input.getTelefone());
        pessoaRepository.salvar(atual);
    }
}
