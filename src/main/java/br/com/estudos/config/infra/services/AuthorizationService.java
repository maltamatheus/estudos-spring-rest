package br.com.estudos.config.infra.services;

import br.com.estudos.config.infra.domains.User;
import br.com.estudos.config.infra.enums.EnumRolesUsuario;
import br.com.estudos.config.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthorizationService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByLogin(login);
        if(userDetails == null){
            log.error("Usuário/senha inválido(a) ou inexistente. Login:{}", login);
            throw new RuntimeException("Usuário inválido ou inexistente");
        }

        return userDetails;
    }

    public String obterRoleUsuarioLogado(){
        User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usuario.getRole().toString();
    }
}
