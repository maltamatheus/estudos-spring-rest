package br.com.estudos.domains.embeddables;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Set;

@Data
@Embeddable
public class DetalhesContato {

    private String email;

    @ElementCollection
    private Set<String> telefones;
}
