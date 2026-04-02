package br.com.estudos.config.infra.domains;

import br.com.estudos.config.infra.enums.EnumRolesUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name="UsuariosEntity")
@Table(name="tab_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EnumRolesUsuario role;

    @Column(name="flag_ativo")
    private Boolean ativo;

    public User(String login, String password, EnumRolesUsuario role, Boolean ativo) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.ativo = ativo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == EnumRolesUsuario.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                            new SimpleGrantedAuthority("ROLE_BLACK"),
                            new SimpleGrantedAuthority("ROLE_GOLD"));
        } else if(this.role == EnumRolesUsuario.BLACK){
            return List.of(new SimpleGrantedAuthority("ROLE_BLACK"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_GOLD"));
        }
    }

    @Override
    public String getUsername() {
        return this.login;
    }
}
