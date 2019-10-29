package com.spring.teste.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// 1. Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("murillo").password("1234").roles("ADMIN")
			.and()
			.withUser("aux").password("aux").roles("AUX");
	}
	
	
	// 2. Aplicando a segurança em nossa aplicação 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	// 3. Liberando recursos estáticos para serem liberados acesso
	@Override
 	public void configure(WebSecurity web) {
 		web.ignoring().antMatchers("/*.html");
 	}
	
	
	// Desabilitando encoder da senha
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
