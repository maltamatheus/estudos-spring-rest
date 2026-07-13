package br.com.estudos.domains.dto.request;

import br.com.estudos.domains.Cliente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {
    private Cliente cliente;
    private LocalDateTime dataPedido;
}
