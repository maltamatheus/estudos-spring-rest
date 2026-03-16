package br.com.testes.domains.pk;

import br.com.testes.enums.EnumTipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class DocumentoPK {
    @Enumerated(EnumType.STRING)
    private EnumTipoDocumento tipo;
    @Column(name="numero_documento")
    private String numero;
}
