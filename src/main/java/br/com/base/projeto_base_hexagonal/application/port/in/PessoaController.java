package br.com.base.projeto_base_hexagonal.application.port.in;


import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.PessoaDto;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaController {

    void salvarPessoa(PessoaDto pessoa);
    List<Pessoa>  buscarTodos();

    Pessoa buscarPessoa(Long idPessoa);

    void alterarPessoa(Long idPessoa, PessoaDto pessoa);

    void deletarPesso(Long idPessoa);
}
