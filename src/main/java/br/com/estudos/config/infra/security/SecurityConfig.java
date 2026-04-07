package br.com.estudos.config.infra.security;

import br.com.estudos.config.infra.domains.User;
import br.com.estudos.config.infra.domains.dto.UsuarioRegistradoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Não cria HttpSessions
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"/auth/login","/auth/logout").permitAll()
//                                .anyRequest().permitAll() // LIBERA TUDO
                                .requestMatchers("/promocoes","/promocoes/**").hasAuthority("ROLE_BLACK")
                                .requestMatchers("/**").hasRole("ADMIN") // Role Admin pode tudo
//                                .requestMatchers(HttpMethod.GET,"/fornecedores**"
//                                                                        ,"/documentos**"
//                                                                        ,"/avaliacoes**")
//                                    .hasAuthority("ROLE_VIEWER")
//                                .requestMatchers(HttpMethod.GET,"/analytics/**")
//                                    .hasRole("AUDITOR")
//                                .requestMatchers(HttpMethod.POST,"/auth/refresh")
//                                    .authenticated()
                                .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .logout((logout) -> logout.logoutSuccessUrl("/auth/logout"))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
