package br.com.testes.domains;

import br.com.testes.enums.EnumTipoDocumento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
@Setter
public class Documento {

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento")
    private EnumTipoDocumento tipoDocumento;

    @Column(name="num_documento")
    private String numDocumento;
}
