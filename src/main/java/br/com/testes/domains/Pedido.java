package br.com.testes.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name="tab_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Column(name="data_pedido")
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate dtPedido;
}
