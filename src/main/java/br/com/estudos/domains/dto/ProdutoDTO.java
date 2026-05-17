package br.com.estudos.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTO {
    private String nome;
    private String tipoProduto;
    private Integer tipoDocumento;
}
