package br.com.estudos.config.infra.services;

import br.com.estudos.config.infra.domains.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Slf4j
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try{
            log.info("Matheus - Usando a chave secret: {}",secret);
            Algorithm algorithm =Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api-m2ra-auth")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpireInstant())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro na criação do Token",e);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api-m2ra-auth")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant generateExpireInstant(){
        log.info("-----------------------------------------------------");
        log.info("Token gerado em: {}", LocalDateTime.now());
        log.info("Token expira em: {}", LocalDateTime.now().plusHours(2));
        log.info("-----------------------------------------------------");
        return LocalDateTime.now()
                .plusHours(4)
                .toInstant(ZoneOffset.UTC);
    }
}
