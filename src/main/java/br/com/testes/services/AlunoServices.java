package br.com.testes.services;

import br.com.testes.domains.Aluno;
import br.com.testes.repositories.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
//@Service
public class AlunoServices {

    private Aluno aluno;

//    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> obterAluno(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno inserirAluno(Aluno aluno) {
        return salvarAluno(aluno);
    }

//    public Aluno atualizarAluno(Aluno aluno){
//        Optional<Aluno> optionalAluno = this.obterAluno(aluno.getId());
//
//        Aluno novoAluno = new Aluno();
//
//        if(optionalAluno.isEmpty()){
//            return null;
//        } else {
//            novoAluno.setPessoa(aluno.getPessoa());
//        }
//
//        return salvarAluno(novoAluno);
//    }

    public AlunoServices(Aluno aluno){
        this.aluno = aluno;
    }

    public Aluno getAluno(){
        return this.aluno;
    }

     private Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }
}
