package br.com.testes.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Embeddable
public class Pessoa {

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascto")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtNascto;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="codigo_assinatura")
    private Set<Documento> documentos;
}
