package br.com.base.projeto_base_hexagonal.adapter.inboud.controller;


import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.PessoaDto;
import br.com.base.projeto_base_hexagonal.adapter.inboud.mapper.PessoaDtoMapper;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.core.usecase.*;
import br.com.base.projeto_base_hexagonal.application.port.in.PessoaController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class PessoaControllerImp implements PessoaController {
    private final CadastrarPessoaUseCase cadastrarPessoaUseCase;
    private final AlterarPessoaUseCase alterarPessoaUseCase;
    private final BuscarPessoaUseCase buscarPessoaUseCase;
    private final BuscarTodosPessoaUseCase buscarTodosUseCase;
    private final DeletarPessoaUseCase detetarPessoaUseCase;
    private final PessoaDtoMapper pessoaDtoMapper;

    @Operation(summary = "Salvar nova pessoa")
    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void salvarPessoa(@RequestBody @Valid PessoaDto pessoa){
        cadastrarPessoaUseCase.salvar(pessoaDtoMapper.toEntitie(pessoa));
    }

    @Operation(summary = "Buscar todos ")
    @GetMapping("/buscar-todos")
    @Override
    public List<Pessoa>  buscarTodos(){
        return buscarTodosUseCase.buscarTodos();
    }

    @GetMapping("/buscar/{idPessoa}")
    @Override
    public Pessoa buscarPessoa(@PathVariable Long idPessoa){
        return buscarPessoaUseCase.buscarPorId(idPessoa);
    }

    @Operation(summary = "Alterar Pessoa.")
    @PutMapping("/alterar/{idPessoa}")
    @Override
    public void alterarPessoa(@PathVariable Long idPessoa,
                              @RequestBody @Valid PessoaDto pessoa){
        alterarPessoaUseCase.alterarPessoa(pessoaDtoMapper.toEntitie(pessoa), idPessoa);
    }

    @Operation(summary = "Deletar Pessoa.")
    @DeleteMapping("/delete/{idPessoa}")
    @Override
    public void deletarPesso(@PathVariable Long idPessoa){
        detetarPessoaUseCase.deletarPorId(idPessoa);
    }

}
