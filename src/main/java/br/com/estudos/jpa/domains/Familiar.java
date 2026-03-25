package br.com.estudos.jpa.domains;

import br.com.estudos.jpa.enums.EnumTipoFamiliar;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="tab_familiares",
       uniqueConstraints = {@UniqueConstraint(name="documento_uk",columnNames = {"tipo_documento","numero_documento"})})
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private EnumTipoFamiliar familiar;

    private DadosPessoais dadosPessoais;

    @ManyToOne(cascade = CascadeType.ALL)
    private Assinante codigoAssinatura;
}
