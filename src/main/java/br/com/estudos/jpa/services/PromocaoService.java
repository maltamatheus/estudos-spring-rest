package br.com.estudos.jpa.services;

import br.com.estudos.config.infra.services.UsuarioService;
import br.com.estudos.jpa.domains.entities.Promocao;
import br.com.estudos.jpa.enums.EnumNivelPromocao;
import br.com.estudos.jpa.repositories.PromocaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromocaoService {

    private UsuarioService usuarioService;
    private PromocaoRepository repository;

    public List<Promocao> obterPromocoes(EnumNivelPromocao nivel){
//        return this.repository.findAll().stream()
//                .filter(p-> p.getNivel().equals(nivel))
//                .toList();
        return repository.findAll();
    }

    public Promocao criarNovaPromocao(Promocao nova){
        return repository.save(nova);
    }

    public EnumNivelPromocao obterNivelPorRoleUsuario(){
        return EnumNivelPromocao.valueOf(usuarioService.obterUsuarioRegistrado().getRole().toString());
    }
}
