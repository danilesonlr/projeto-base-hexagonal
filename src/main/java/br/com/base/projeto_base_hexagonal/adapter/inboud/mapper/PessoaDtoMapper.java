package br.com.base.projeto_base_hexagonal.adapter.inboud.mapper;

import br.com.base.projeto_base_hexagonal.adapter.inboud.dto.PessoaDto;
import br.com.base.projeto_base_hexagonal.application.core.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaDtoMapper  {


    PessoaDto toDto(Pessoa entitie);

    @Mapping(target = "id", ignore = true) //ignorando campo ID
    @Mapping(target = "endereco", ignore = true)
        //@Mapping(source = "name", target = "username") //e possivel mapear os campos caso seja diferentes.
    Pessoa toEntitie(PessoaDto pessoa);
}
