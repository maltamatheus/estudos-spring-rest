package br.com.estudos.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tab_clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    public Cliente(String nome, LocalDate dataNascto) {
        this.nome = nome;
        this.dataNascto = dataNascto;
    }
    public Cliente(String nome, LocalDate dataNascto, Set<Pedido> pedidos) {
        this.nome = nome;
        this.dataNascto = dataNascto;
        this.pedidos = new LinkedHashSet<>(pedidos);
    }
}