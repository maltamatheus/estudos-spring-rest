package br.com.estudos.jpa.domains.dto;

import br.com.estudos.jpa.domains.DadosPessoais;
import br.com.estudos.jpa.domains.entities.FamiliarEntity;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssinanteRequestDto {
    private DadosPessoais dadosPessoais;
    private Set<FamiliarRequestDto> familiares;
}
