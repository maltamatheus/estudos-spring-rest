package br.com.estudos.jpa.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tab_assinaturas", uniqueConstraints = {@UniqueConstraint(columnNames= {"tipo_documento","numero_documento"})})
public class Assinante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID codigoAssinatura;
    @OneToMany(mappedBy = "codigoAssinatura",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Familiar> familiares;
    @Embedded
    private DadosPessoais dadosPessoais;
}
