package br.com.base.projeto_base_hexagonal.application.port.out;


import br.com.base.projeto_base_hexagonal.application.core.domain.Endereco;

public interface EnderecoGateway {

    Endereco buscarEnderecoPorCep(String cep);
}
