package br.com.estudos.domains.testes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

public final class FinalClass {
    private Usuario usuario;

    public FinalClass(final Usuario usuario){
        this.usuario = usuario;
    }
}
