package br.com.estudos.domains;

import br.com.estudos.domains.embeddables.DetalhesContato;
import jakarta.persistence.*;

@Entity
@Table(name="tab_fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @CollectionTable(name = "tab_telefones_fornecedores", joinColumns = @JoinColumn(name="id_fornecedor"))
    private DetalhesContato contato;
}
