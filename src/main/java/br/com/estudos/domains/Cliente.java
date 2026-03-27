package br.com.estudos.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="tab_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "data_nascto")
    private LocalDate dataNascto;

    @OneToMany(mappedBy = "cliente")
    Set<Pedido> pedidos;
}