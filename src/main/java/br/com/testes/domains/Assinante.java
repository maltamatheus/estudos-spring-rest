package br.com.testes.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "tab_assinantes")
public class Assinante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAssinatura;
    @Embedded
    private Pessoa dadosPessoais;
    @OneToMany(mappedBy = "codigoAssinatura",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Familiar> familiares;
}
