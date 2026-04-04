package br.com.estudos.jpa.services;

import br.com.estudos.jpa.domains.dto.AssinanteRequestDto;
import br.com.estudos.jpa.domains.entities.AssinanteEntity;
import br.com.estudos.jpa.domains.mappers.AssinanteMapper;
import br.com.estudos.jpa.repositories.AssinaturaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssinaturaService {
    private AssinaturaRepository assinaturaRepository;
    private AssinanteMapper assinanteMapper;

    public AssinanteEntity criarAssinante(AssinanteRequestDto assinanteRequestDto){
        AssinanteEntity novoAssinante = assinanteMapper.dtoToEntity(assinanteRequestDto);
        return assinaturaRepository.save(novoAssinante);
    }
}
