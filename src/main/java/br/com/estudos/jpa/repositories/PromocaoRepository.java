package br.com.estudos.jpa.repositories;

import br.com.estudos.jpa.domains.entities.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao,Long> {


}
