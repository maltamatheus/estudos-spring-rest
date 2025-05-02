package br.com.testes.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TAB_INTERESSADOS")
@Getter
@Setter
public class Interessado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Pessoa pessoa;

    @Column(name = "dt_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
