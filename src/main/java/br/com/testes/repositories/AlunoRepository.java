package br.com.testes.repositories;

import br.com.testes.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
