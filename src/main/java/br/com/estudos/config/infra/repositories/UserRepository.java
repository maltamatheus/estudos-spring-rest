package br.com.estudos.config.infra.repositories;

import br.com.estudos.config.infra.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByLogin(String login);

    @Query("select ue " +
            "from UsuariosEntity ue " +
            "where ue.login = :login")
    User obterUsuarios(String login);
}
