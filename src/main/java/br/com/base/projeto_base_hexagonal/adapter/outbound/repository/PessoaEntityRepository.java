package br.com.base.projeto_base_hexagonal.adapter.outbound.repository;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEntityRepository extends JpaRepository<PessoaEntity, Long> {
}
