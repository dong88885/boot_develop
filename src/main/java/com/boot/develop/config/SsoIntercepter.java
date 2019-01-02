package com.boot.develop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;


public class SsoIntercepter  implements HandlerInterceptor {
	
	 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		    System.err.println("===preo handler=principal user：");
		    //response.setHeader("Access-Control-Allow-Origin","*");
		    //Access-Control-Allow-Headers 
		    //response.setHeader("Access-Control-Allow-Headers","Accept,Content-Type,access-token");
		   // response.setHeader("Access-Control-Allow-Credentials", "true");
	       // response.setHeader("Access-Control-Allow-Methods", "*");
	       // response.setHeader("Access-Control-Expose-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,access-token");
	        
		    SecurityContext securityContext = SecurityContextHolder.getContext();
	        Authentication authentication = securityContext.getAuthentication();

	        if (authentication != null && authentication.getDetails() != null
	                && authentication.getDetails() instanceof SimpleKeycloakAccount) {
	        
	            SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();
	          
	            System.out.println("====principal user："+details.getPrincipal().getName());
	            System.out.println("======webtoken:"+ details.getKeycloakSecurityContext().getTokenString());
	            details.getRoles().forEach(role->{
	            	System.out.println("====login role:"+role);	                        	
	            });
	            
	        
	    }
		 
		return true;	       
	}
	


}
