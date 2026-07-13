package br.com.estudos.mappers;

import br.com.estudos.domains.Cliente;
import br.com.estudos.domains.Pedido;
import br.com.estudos.domains.dto.request.ClienteDTO;
import br.com.estudos.domains.dto.request.PedidoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {
    Pedido toEntity (PedidoDTO dto);
    PedidoDTO toDto (Pedido pedido);
}
