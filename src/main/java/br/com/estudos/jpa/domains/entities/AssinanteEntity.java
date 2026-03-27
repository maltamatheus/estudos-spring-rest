package br.com.estudos.jpa.domains.entities;

import br.com.estudos.jpa.domains.DadosPessoais;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tab_assinaturas", uniqueConstraints = {@UniqueConstraint(columnNames= {"tipo_documento","numero_documento"})})
public class AssinanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codigoAssinatura;

    @OneToMany(mappedBy = "codigoAssinatura")
    private Set<FamiliarEntity> familiares;
    @Embedded
    private DadosPessoais dadosPessoais;
}
