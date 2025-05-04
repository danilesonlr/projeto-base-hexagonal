package br.com.base.projeto_base_hexagonal.adapter.outbound.mapper;

import br.com.base.projeto_base_hexagonal.adapter.outbound.entity.EnderecoEntity;
import br.com.base.projeto_base_hexagonal.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntitie(EnderecoEntity entity);

    @Mapping(target = "id", ignore = true)
    EnderecoEntity toEntity(Endereco pessoa);
}
