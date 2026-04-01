package br.com.estudos.config.infra.controller;

import br.com.estudos.config.infra.domains.dto.AuthenticationDto;
import br.com.estudos.config.infra.domains.User;
import br.com.estudos.config.infra.domains.dto.LoginResponseDto;
import br.com.estudos.config.infra.domains.dto.NovoUsuarioDto;
import br.com.estudos.config.infra.domains.dto.UsuarioRegistradoDto;
import br.com.estudos.config.infra.repositories.UserRepository;
import br.com.estudos.config.infra.services.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto dto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(dto.login(), dto.password());

        Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/novo")
    public ResponseEntity register(@RequestBody @Valid NovoUsuarioDto dto){
        if(userRepository.findByLogin(dto.login()) != null){
            throw new RuntimeException("Login já registrado no cadastro de usuários");
        }
        try{
            User user = userRepository.save(new User(dto.login(),new BCryptPasswordEncoder().encode(dto.password()),dto.role(),dto.ativo()));
            return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioRegistradoDto(user.getLogin(), user.getRole()));
        } catch (Exception e){
            throw new RuntimeException("Falha ao registrar novo usuário\n"+e.getLocalizedMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Logout realizado com sucesso");
    }
}
