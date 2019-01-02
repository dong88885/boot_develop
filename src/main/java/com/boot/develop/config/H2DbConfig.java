package com.boot.develop.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class H2DbConfig {
	
	 // TCP port for remote connections, default 9092
    @Value("${h2.tcp.port:9092}")
    private String h2TcpPort;
 
    // Web port, default 8082
    @Value("${h2.web.port:8082}")
    private String h2WebPort;
 
    @Bean
    @ConditionalOnExpression("${h2.tcp.enabled:false}")
    public Server h2TcpServer() throws SQLException {
    	//Server.
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", h2TcpPort).start();
    }
 
 
   @Bean
    @ConditionalOnExpression("${h2.web.enabled:true}")
    public Server h2WebServer() throws SQLException {
    	//return null;
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", h2WebPort).start();
    }
   
   //asdfasdfasdfasdfadf
   //asdfas
   //asdfasdfasdfasfasdfasdfasdf
   //asdfasdfasdffasdfasdf

}
