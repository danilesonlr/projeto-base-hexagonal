package br.com.base.projeto_base_hexagonal.adapter.outbound.repository;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoEntityRepository extends JpaRepository<EnderecoEntity, Long> {
}
