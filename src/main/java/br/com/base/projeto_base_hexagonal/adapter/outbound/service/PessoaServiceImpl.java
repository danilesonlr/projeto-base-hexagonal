package br.com.base.projeto_base_hexagonal.adapter.outbound.service;

import br.com.base.projeto_base_hexagonal.adapter.outbound.mapper.PessoaMapper;
import br.com.base.projeto_base_hexagonal.adapter.outbound.repository.PessoaEntityRepository;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import br.com.base.projeto_base_hexagonal.application.port.out.PessoaDomainGateway;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaServiceImpl implements PessoaDomainGateway {

    private final PessoaEntityRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaServiceImpl(@Lazy PessoaEntityRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    @Transactional
    public void salvar(Pessoa pessoa) {

        pessoaRepository.save(pessoaMapper.toEntity(pessoa));
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaMapper
                .toEntitie(pessoaRepository.findById(id)
                .orElseThrow());
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(e -> pessoaMapper.toEntitie(e))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
