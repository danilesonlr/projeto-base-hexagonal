package br.com.base.projeto_base_hexagonal.adapter.outbound.service;


import br.com.base.projeto_base_hexagonal.adapter.outbound.integration.ViaCepClient;
import br.com.base.projeto_base_hexagonal.application.core.domain.Endereco;
import br.com.base.projeto_base_hexagonal.application.port.out.EnderecoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoServiceImpl implements EnderecoGateway {
    private final ViaCepClient viaCepClient;

    @Override
    public Endereco buscarEnderecoPorCep(String cep) {
        try {
            return viaCepClient.buscar(cep);
        } catch (Exception e){
            log.error("Falha na busca do CEP: {}", e.getMessage());
            return null;
        }
    }
}
