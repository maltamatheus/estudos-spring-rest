package br.com.estudos.domains.mappers;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.dto.request.ClienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity (ClienteDto clienteDto);
}
