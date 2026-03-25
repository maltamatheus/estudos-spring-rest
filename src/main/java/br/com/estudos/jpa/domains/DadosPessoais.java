package br.com.estudos.jpa.domains;

import br.com.estudos.jpa.domains.pk.DocumentoPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Embeddable
public class DadosPessoais {

    private DocumentoPK documento;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascto")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtNascto;
}
