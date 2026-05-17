package br.com.estudos.domains;

import br.com.estudos.domains.enums.EnumTipoProduto;
import br.com.estudos.domains.generics.enums.EnumTipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    private String nome;
    private EnumTipoProduto tipo;
    private EnumTipoDocumento tipoDocto;
}
