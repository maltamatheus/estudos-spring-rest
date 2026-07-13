package br.com.estudos.domains.testes;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Mapper
public interface TaxaIOFMapper {

    @Mapping(source = "grupoRamo",target = "codigoGrupoRamo")
    @Mapping(source = "ramo",target = "codigoRamo")
    @Mapping(source = "dataInicio",target = "dataInicioVigencia")
    @Mapping(source = "dataFimVigencia",target = "dataTerminoVigencia")
    TaxaIOF dtoToPojo(TaxaIOFDTO dto);

    default Date map(LocalDateTime value) {
        if (value == null) {
            return null;
        }
        return Date.from(value.atZone(ZoneId.systemDefault()).toInstant());
    }
}
