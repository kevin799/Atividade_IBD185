package br.gov.sp.fatec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	//
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication() //Ao se fazer o uso de autenticações ele será salvo atraves dessa funcao
			
			.withUser("admin").password(
					passwordEncoder().encode("admin")) //passwordEncoder criado na classe para cripografar a senha
					.roles("ADMIN") //Autorizacao com usuario especifico
			
			.and()
			
			
			.withUser("dan").password(
					passwordEncoder().encode("dan123")) //passwordEncoder criado na classe para cripografar a senha
					.roles("USER");
		
		
	}
	@Override
	//Estrutura basica para autorizar requests
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() //Autorizando requests de qualquer origem
			.anyRequest().authenticated() //Autorizar acesso somente para acesso autenticado
			.and()
			.httpBasic();// Autorizacoes atraves de HTTP basico
	}
	
	@Bean
	//Realizar a criptografia da senha com HASH
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
