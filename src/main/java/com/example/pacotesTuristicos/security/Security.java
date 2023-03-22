package com.example.pacotesTuristicos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Security extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(getPasswordEncoder())
		.withUser("will")
		.password(getPasswordEncoder().encode("123"))
		.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.
		authorizeRequests()
		.antMatchers("/", "/pacotes", "/promocoes", "/contato", "/sobrenos","/register",
				"/api/**", "/**/*.*", "/h2-console/**").permitAll()
			.anyRequest().hasRole("USER")
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
			.logout()
			.logoutUrl("/logout")
			.permitAll()
		.and()
		.csrf().ignoringAntMatchers("/api/**", "/h2-console/**");
	}

}