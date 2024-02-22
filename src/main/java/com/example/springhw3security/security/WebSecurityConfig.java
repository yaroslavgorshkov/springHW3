package com.example.springhw3security.security;

import com.example.springhw3security.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/simpleUser").hasAuthority(UserRole.SIMPLE_USER.name())
					.requestMatchers("/adminUser").hasAuthority(UserRole.ADMIN.name())
					.requestMatchers("/ownerUser").hasAuthority(UserRole.OWNER.name())
					.anyRequest().authenticated()
			).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
			.logout(LogoutConfigurer::permitAll);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}