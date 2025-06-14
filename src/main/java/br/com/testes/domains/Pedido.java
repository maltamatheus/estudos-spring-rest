package br.com.testes.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(LocalDate dtPedido) {
        this.dtPedido = dtPedido;
    }
}
