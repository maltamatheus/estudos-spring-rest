package br.com.estudos.jpa.services;

import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import br.com.estudos.jpa.repositories.AssinaturaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssinaturaService {
    private AssinaturaRepository assinaturaRepository;

    public AssinanteEntity novoAssinante(AssinanteEntity assinanteEntity){
        return assinaturaRepository.save(assinanteEntity);
    }
}
