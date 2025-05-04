package br.com.base.projeto_base_hexagonal.adapter.outbound.mapper;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.PessoaEntity;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper {

    Pessoa toEntitie(PessoaEntity entity);

    @Mapping(target = "id", ignore = true)
    PessoaEntity toEntity(Pessoa pessoa);
}
