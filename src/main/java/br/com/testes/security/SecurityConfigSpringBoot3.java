package br.com.testes.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
// Classe para setar o Spring Security no Spring Boot 3
// Com esse Bean, o Basic Authentication funciona mesmo sem passar autenticação desde que
// A autenticação tenha gerado cookies
public class SecurityConfigSpringBoot3 {
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
//				.securityContext((securityContext) -> securityContext
//						.requireExplicitSave(false) //Permite gerar a sessão
//				)
//				.httpBasic(c -> Customizer.withDefaults());
//
//		return http.build();
//	}
	
	public void teste() {
		System.out.println("Teste");
	}
}
