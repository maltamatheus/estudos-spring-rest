package br.com.estudos.jpa.domains.mappers;

import br.com.estudos.jpa.domains.DadosPessoais;
import br.com.estudos.jpa.domains.dto.AssinanteRequestDto;
import br.com.estudos.jpa.domains.dto.FamiliarRequestDto;
import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import br.com.estudos.jpa.domains.entities.FamiliarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FamiliarMapper.class})
public interface AssinanteMapper {
    @Mappings({
            @Mapping(source = "dadosPessoais", target = "dadosPessoais"),
            @Mapping(source = "familiares", target = "familiares")
    })
    AssinanteRequestDto entityToDto(AssinanteEntity entity);

    @Mappings({
            @Mapping(target = "dadosPessoais", source = "dadosPessoais"),
            @Mapping(source = "familiares", target = "familiares")
    })
    AssinanteEntity dtoToEntity(AssinanteRequestDto dto);
}