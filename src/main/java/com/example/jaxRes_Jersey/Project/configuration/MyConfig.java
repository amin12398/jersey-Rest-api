package com.example.jaxRes_Jersey.Project.configuration;

import com.example.jaxRes_Jersey.Project.controllers.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration du service rest avec jersey
@Configuration
public class MyConfig {

@Bean
    public ResourceConfig resourceConfig(){

    ResourceConfig jerseyConfig = new ResourceConfig();

    jerseyConfig.register(CompteRestJaxRSAPI.class);

    return jerseyConfig;
}



}
