package br.com.testes.domains;

import br.com.testes.domains.pk.DocumentoPK;
import br.com.testes.enums.EnumTipoDocumento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="tab_documentos")
public class Documento {
    @EmbeddedId
    private DocumentoPK documento;
}
