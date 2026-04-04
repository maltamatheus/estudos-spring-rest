package br.com.estudos.config.infra.services;

import br.com.estudos.config.infra.domains.User;
import br.com.estudos.config.infra.domains.dto.UsuarioRegistradoDto;
import br.com.estudos.config.infra.enums.EnumRolesUsuario;
import br.com.estudos.config.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UserRepository repository;

    public List<User> obterUsuarios(){
        return repository.findAll();
    }

    public User obterUsuario(String login){
        return repository.obterUsuarios(login);
    }

    public User salvar(User novo){
        return repository.save(novo);
    }

    public User obterUsuarioRegistrado(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
