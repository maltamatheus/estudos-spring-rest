package br.com.estudos.domains.dto.request;

import br.com.estudos.domains.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class ClienteDTO {
    private String nome;
    private LocalDate dataNascto;
    private Set<Pedido> pedidos;
}
