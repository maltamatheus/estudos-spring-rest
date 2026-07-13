package br.com.estudos.domains.testes;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TaxaIOF {
    private Integer codigoGrupoRamo;
    private Integer codigoRamo;
    private BigDecimal percentualIOF;
    private Date dataInicioVigencia;
    private Date dataTerminoVigencia;
}
