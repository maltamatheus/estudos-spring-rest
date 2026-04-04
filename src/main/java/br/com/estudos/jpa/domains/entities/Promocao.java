package br.com.estudos.jpa.domains.entities;

import br.com.estudos.jpa.enums.EnumNivelPromocao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="PromocoesEntity")
@Table(name="tab_promocoes")
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumNivelPromocao nivel;
}
