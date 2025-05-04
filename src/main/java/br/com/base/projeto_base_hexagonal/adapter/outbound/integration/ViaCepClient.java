package br.com.base.projeto_base_hexagonal.adapter.outbound.integration;

import br.com.base.projeto_base_hexagonal.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws") // url="${notification-api.url}"
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    Endereco buscar(@PathVariable("cep") String cep);
}
