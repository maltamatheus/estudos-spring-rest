package br.com.estudos.jpa.domains.mappers;

import br.com.estudos.jpa.domains.dto.AssinanteRequestDto;
import br.com.estudos.jpa.domains.dto.FamiliarRequestDto;
import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import br.com.estudos.jpa.domains.entities.FamiliarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FamiliarMapper {
    @Mappings({
            @Mapping(source = "dadosPessoais", target = "dadosPessoais"),
            @Mapping(source = "tipoFamiliar", target = "tipoFamiliar")
    })
    FamiliarRequestDto entityToDto(FamiliarEntity entity);

    @Mappings({
            @Mapping(target = "dadosPessoais", source = "dadosPessoais"),
            @Mapping(source = "tipoFamiliar", target = "tipoFamiliar")
    })
    FamiliarEntity dtoToEntity(FamiliarRequestDto dto);
}