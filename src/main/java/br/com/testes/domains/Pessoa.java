package br.com.testes.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable
@Getter
@Setter
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
