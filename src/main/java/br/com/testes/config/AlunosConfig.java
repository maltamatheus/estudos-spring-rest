package br.com.testes.config;

import br.com.testes.domains.Aluno;
import br.com.testes.domains.Documento;
import br.com.testes.domains.Pessoa;
import br.com.testes.enums.EnumTipoDocumento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Set;

//@Configuration
//@Slf4j
public class AlunosConfig {

//    @Bean
//    public Aluno aluno(){
//        Documento rg = new Documento();
//        rg.setTipoDocumento(EnumTipoDocumento.RG);
//        rg.setNumDocumento("123456789");
//
//        Documento cpf = new Documento();
//        cpf.setTipoDocumento(EnumTipoDocumento.CPF);
//        cpf.setNumDocumento("987654321");
//
//        Documento cnh = new Documento();
//        cnh.setTipoDocumento(EnumTipoDocumento.CNH);
//        cnh.setNumDocumento("111222333444");
//
//        Set<Documento> documentos = Set.of(rg,cpf,cnh);
//
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNomeCompleto("Matheus Malta de Aguiar");
//        pessoa.setDocumentos(documentos.stream().toList());
//
//        Aluno novoAluno = new Aluno();
//        novoAluno.setPessoa(pessoa);
//        novoAluno.setDataInclusao(LocalDateTime.now());
//
//        log.info("Bean de Aluno Gerado: {}",novoAluno.getPessoa());
//
//        return novoAluno;
//    }
}
