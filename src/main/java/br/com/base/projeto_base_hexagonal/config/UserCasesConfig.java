package br.com.base.projeto_base_hexagonal.config;

import br.com.base.projeto_base_hexagonal.adapter.outbound.integration.ViaCepClient;
import br.com.base.projeto_base_hexagonal.adapter.outbound.mapper.PessoaMapper;
import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.PessoaEntityRepository;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.EnderecoServiceImpl;
import br.com.base.projeto_base_hexagonal.adapter.outbound.service.PessoaServiceImpl;
import br.com.base.projeto_base_hexagonal.application.core.usecase.*;
import br.com.base.projeto_base_hexagonal.application.core.usecase.impl.*;
import br.com.base.projeto_base_hexagonal.application.port.out.EnderecoGateway;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCasesConfig {

    @Bean
    public PessoaDomainGateway pessoaDomainRepository(PessoaEntityRepository pessoaRepository,
                                                      PessoaMapper pessoaMapper) {
        return new PessoaServiceImpl(pessoaRepository, pessoaMapper);
    }

    @Bean
    public CadastrarPessoaUseCase cadastrarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository,
                                                         EnderecoGateway enderecoGateway) {
        return new CadastrarPessoaUseCaseImpl(pessoaDomainRepository, enderecoGateway);
    }

    @Bean
    public AlterarPessoaUseCase alterarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new AlterarPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public BuscarPessoaUseCase buscarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new BuscarPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public BuscarTodosPessoaUseCase buscarTodosPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new BuscarTodosPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public DeletarPessoaUseCase deletarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new DeletarPessoaUseCaseImpl(pessoaDomainRepository);
    }
}
