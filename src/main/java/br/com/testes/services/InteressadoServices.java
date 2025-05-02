package br.com.testes.services;

import br.com.testes.domains.Interessado;
import br.com.testes.repositories.InteressadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteressadoServices {

    @Autowired
    InteressadoRepository interessadoRepository;

    public List<Interessado> obterLista(){
        return interessadoRepository.findAll();
    }

    public Optional<Interessado> obterInteressado(Long id) {
        return interessadoRepository.findById(id);
    }

    public Interessado criarInteressado(Interessado interessado) {
        return salvarInteressado(interessado);
    }

    public Interessado atualizarInteressado(Interessado interessado){
        Optional<Interessado> optionalInteressado = this.obterInteressado(interessado.getId());

        Interessado novoInteressado = new Interessado();

        if(optionalInteressado.isEmpty()){
            return null;
        } else {
            novoInteressado.setPessoa(interessado.getPessoa());
        }

        return salvarInteressado(novoInteressado);
    }

     private Interessado salvarInteressado(Interessado interessado){
        return interessadoRepository.save(interessado);
    }
}
