package br.com.estudos.jpa.domains.pk;

import br.com.estudos.jpa.enums.EnumTipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class DocumentoPK {

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento")
    private EnumTipoDocumento tipo;
    @Column(name="numero_documento")
    private String numero;
}
