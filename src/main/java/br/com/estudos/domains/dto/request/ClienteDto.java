package br.com.estudos.domains.dto.request;

import br.com.estudos.domains.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ClienteDto {
    private String nome;
    private LocalDate dataNascto;
    private Set<Pedido> pedidos;
}
