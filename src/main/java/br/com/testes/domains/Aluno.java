package br.com.testes.domains;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "TAB_ALUNOS")
//@Getter
//@Setter
public class Aluno {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Embedded
    private Pessoa pessoa;

//    @Column(name = "dt_inclusao")
    private LocalDateTime dataInclusao;

//    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

}
