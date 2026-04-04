package br.com.estudos.config.infra.controller;

import br.com.estudos.config.infra.domains.User;
import br.com.estudos.config.infra.domains.dto.AuthenticationDto;
import br.com.estudos.config.infra.domains.dto.LoginResponseDto;
import br.com.estudos.config.infra.domains.dto.NovoUsuarioDto;
import br.com.estudos.config.infra.domains.dto.UsuarioRegistradoDto;
import br.com.estudos.config.infra.enums.EnumRolesUsuario;
import br.com.estudos.config.infra.repositories.UserRepository;
import br.com.estudos.config.infra.services.TokenService;
import br.com.estudos.config.infra.services.UsuarioService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService service;

    @PostMapping("/novo")
    public ResponseEntity register(@RequestBody @Valid NovoUsuarioDto dto){
        if(service.obterUsuario(dto.login()) != null){
            throw new RuntimeException("Login já registrado no cadastro de usuários");
        }
        try{
            User user = service.salvar(new User(dto.login(),new BCryptPasswordEncoder().encode(dto.password()),dto.role(),dto.ativo()));
            return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioRegistradoDto(user.getLogin(), user.getRole()));
        } catch (Exception e){
            throw new RuntimeException("Falha ao registrar novo usuário\n"+e.getLocalizedMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obterDadosUsuarios(@RequestParam(required = false, defaultValue = "false") Boolean todos) throws IOException {

        if (service.obterUsuarioRegistrado().getRole().equals(EnumRolesUsuario.ADMIN) && todos){
            return ResponseEntity.ok(service.obterUsuarios());
        }
        return ResponseEntity.ok(service.obterUsuario(service.obterUsuarioRegistrado().getLogin()));
    }
}
