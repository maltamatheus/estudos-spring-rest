package br.com.estudos.domains.testes;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestesComDatas extends InicioFimVigenciaDTO{
    private LocalDateTime hoje;
}