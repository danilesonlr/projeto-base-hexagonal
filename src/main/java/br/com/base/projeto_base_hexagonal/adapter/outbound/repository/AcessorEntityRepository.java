package br.com.base.projeto_base_hexagonal.adapter.outbound.repository;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.acesso.AcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessorEntityRepository extends JpaRepository<AcessoEntity, Long> {
    Optional<AcessoEntity> findByLogin(String login);
}
