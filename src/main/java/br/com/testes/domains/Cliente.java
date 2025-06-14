package br.com.testes.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tab_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name="data_nascto")
    private LocalDate dataNascto;

    @OneToMany(mappedBy = "cliente")
    List<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascto() {
        return dataNascto;
    }

    public void setDataNascto(LocalDate dataNascto) {
        this.dataNascto = dataNascto;
    }

}
