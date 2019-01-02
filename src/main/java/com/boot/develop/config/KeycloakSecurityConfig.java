package com.boot.develop.config;

import java.util.Arrays;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {


	 @Bean
	    public RestTemplate getRestTemplate() {
	        return new RestTemplate();
	    }

	    /**
	     * Registers the KeycloakAuthenticationProvider with the authentication manager.
	     */
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) {
	        KeycloakAuthenticationProvider keycloakAuthenticationProvider =
	                keycloakAuthenticationProvider();
	        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
	        auth.authenticationProvider(keycloakAuthenticationProvider);
	    }

	    @Bean
	    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
	        return new KeycloakSpringBootConfigResolver();
	    }

	    /**
	     * Defines the session authentication strategy.
	     */
	    @Bean
	    @Override
	    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
	        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        super.configure(http);
	        http.cors().and().csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	                .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
	                        "/configuration/security", "/swagger-ui.html", "/webjars/**",
	                        "/h2-console/**")
	                .permitAll().anyRequest().authenticated()
	                .and().headers().frameOptions().sameOrigin();
	    }

	    /**
	     * Creates a cors filter setting all origins and headers.
	     *
	     * @return CorsConfigurationSource
	     */
	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        final CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("*"));
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
}


