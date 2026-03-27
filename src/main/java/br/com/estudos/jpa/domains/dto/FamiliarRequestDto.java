package br.com.estudos.jpa.domains.dto;

import br.com.estudos.jpa.domains.DadosPessoais;
import br.com.estudos.jpa.enums.EnumTipoFamiliar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamiliarRequestDto {
    private DadosPessoais dadosPessoais;
    private EnumTipoFamiliar tipoFamiliar;
}
