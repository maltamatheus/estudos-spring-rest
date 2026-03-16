package br.com.testes.domains;

import br.com.testes.enums.EnumTipoFamiliar;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tab_familiares")
public class Familiar {
    @Enumerated(EnumType.STRING)
    private EnumTipoFamiliar familiar;
    @EmbeddedId
    private Pessoa dadosPessoais;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="codigo_assinatura")
    private Assinante codigoAssinatura;
}
