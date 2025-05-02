package br.com.testes.repositories;

import br.com.testes.domains.Interessado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressadoRepository extends JpaRepository<Interessado, Long> {


}
