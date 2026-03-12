package br.com.testes.domains;

import br.com.testes.enums.EnumTipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Documento {

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento")
    private EnumTipoDocumento tipoDocumento;

    @Column(name="num_documento")
    private String numDocumento;
}
