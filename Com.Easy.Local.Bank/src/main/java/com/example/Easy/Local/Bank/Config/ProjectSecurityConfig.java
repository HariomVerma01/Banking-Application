package com.example.Easy.Local.Bank.Config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.example.Easy.Local.Bank.filter.CsrfCookieFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@Profile("!prod")
public class ProjectSecurityConfig {
	
	@Bean
	SecurityFilterChain defSecurityFilterChain (HttpSecurity http) throws Exception
	{
		
		CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler=new CsrfTokenRequestAttributeHandler();
		//http.authorizeHttpRequests((requests)->requests.anyRequest().permitAll()); permits all the request
		//http.authorizeHttpRequests((requests)->requests.anyRequest().denyAll()); deny all the request.
		http.sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
		.cors(corsConfig->corsConfig.configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config=new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
				config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));	
				config.setMaxAge(3600L);
				return config;
			}
		}))
		.csrf(csrfConfig->csrfConfig.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
		.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
		.sessionManagement(smc->smc.invalidSessionUrl("/invalidSession").maximumSessions(3).maxSessionsPreventsLogin(true))
		.csrf(csrfConfig-> csrfConfig.disable())
		.authorizeHttpRequests((requests)->requests
		.requestMatchers("/myAccount","/getBalance","/getCards","/getLoan").authenticated()
		.requestMatchers("/getContact","/getNotices","/error","/register","/invalidSession").permitAll());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource)
//	{
//		return new JdbcUserDetailsManager(dataSource);
//	}
//	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
// This is method used to check whethere the password is compromised earlier or not
	
//	@Bean
//	public CompromisedPasswordChecker compromisedPasswordChecker()
//	{
//		return new HaveIBeenPwnedRestApiPasswordChecker();
//	}
	
}
