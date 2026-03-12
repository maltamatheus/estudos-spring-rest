package br.com.testes.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Embeddable
public class Pessoa {

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Embedded
    private Set<Documento> documentos;

    @Column(name = "dt_nascto")
    private LocalDate dataNascto;

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = new HashSet<>(documentos);
    }

    public Set<Documento> getDocumentos(){
        if(documentos.isEmpty()){
            documentos = new HashSet<>();
        }
        return documentos;
    }

}
