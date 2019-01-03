package com.boot.develop.service;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Service
public class KeyCloakService {

	
	 	@Value("${keycloak.realm}")
	    private String realm;

	    @Value("${keycloak-admin.identity-provider}")
	    private String keycloakIdentityProvider;

	  
	    private Keycloak keycloak;
	    
	    
	    public KeyCloakService(Keycloak keycloak) {
	    	
	        this.keycloak = keycloak;
	    }
	    
	    
	    public UserResource findUserById(String id) {

	        log.info("Searching for user in keycloak by id: " + id);

	        return getUserResource().get(id);
	    }

	    
	    
	    private UsersResource getUserResource() {
	    	
	    	//keycloak.tokenManager().
	        return  keycloak.realm(realm).users();
	    }
	    
	    
	   public  List<UserRepresentation> findUserByName(String userName){
		   
	    	
	    	return   getUserResource().search(userName);
	    }
	   
	   public Keycloak gainKeyCloakClient() {
		   
		   
		   return keycloak;
		   
	   }
	
	
}
