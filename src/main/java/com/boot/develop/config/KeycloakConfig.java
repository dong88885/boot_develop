package com.boot.develop.config;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {


    @Value("${keycloak-admin.master-realm}")
    private String masterRealm;

    @Value("${keycloak-admin.admin-username}")
    private String adminUsername;

    @Value("${keycloak-admin.admin-pass}")
    private String adminPass;

    @Value("${keycloak-admin.admin-client-id}")
    private String adminClientId;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;
    
    @Value("${keycloak-admin.admin-client-secret}")
    private String client_secret;

    @Bean
    public Keycloak getKeycloak() {
        //return Keycloak.getInstance(authServerUrl, masterRealm, adminUsername, adminPass,
        //        adminClientId);   	
    	//c5660b49-426c-45e6-8a78-c9eb3f20b1e6 
    	
    	return Keycloak.getInstance(authServerUrl, masterRealm, adminUsername, adminPass,
    	                adminClientId,client_secret);
    }


}
