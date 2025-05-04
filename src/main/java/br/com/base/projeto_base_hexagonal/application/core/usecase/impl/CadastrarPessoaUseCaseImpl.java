package br.com.base.projeto_base_hexagonal.application.core.usecase.impl;


import br.com.base.projeto_base_hexagonal.application.core.domain.Endereco;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.core.exception.BusinessValidateException;
import br.com.base.projeto_base_hexagonal.application.core.exception.enums.ErroCodeEnum;
import br.com.base.projeto_base_hexagonal.application.core.usecase.CadastrarPessoaUseCase;
import br.com.base.projeto_base_hexagonal.application.port.out.EnderecoGateway;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;

public class CadastrarPessoaUseCaseImpl implements CadastrarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;
    private final EnderecoGateway enderecoGateway;

    public CadastrarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository, EnderecoGateway enderecoGateway) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoGateway = enderecoGateway;
    }

    @Override
    public void salvar(Pessoa input) {
        Endereco endereco = getEndereco(input);
        Pessoa pessoa = new Pessoa( input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getDateNascimento(),
                input.getTelefone(),
                input.getCep(),
                endereco);
        pessoaRepository.salvar(pessoa);
    }

    private Endereco getEndereco(Pessoa input) {
        Endereco endereco = null;
        try {
            endereco = enderecoGateway.buscarEnderecoPorCep(input.getCep());
            if (endereco == null) {
                throw new BusinessValidateException(ErroCodeEnum.UC0001.getCode(),
                        ErroCodeEnum.UC0001.getMessage());
            }
        } catch (BusinessValidateException ex) {
            throw ex;
        } catch (Exception e) {
            throw new BusinessValidateException(ErroCodeEnum.UC0002.getCode(),
                    ErroCodeEnum.UC0002.getMessage());
        }
        return endereco;
    }
}
