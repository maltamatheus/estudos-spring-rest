package br.com.estudos.domains.embeddables;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Set;

@Data
@Embeddable
public class DetalhesContato {
    @ElementCollection
    private Set<String> telefones;

    @ElementCollection
    private Set<String> emails;
}
