package it.solvingteam.jerseyLibreria.configuration;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import it.solvingteam.jerseyLibreria.controller.LibreriaController;

@Configuration
public class JerseyConfig extends ResourceConfig {

    private final Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

    @PostConstruct
    public void registerJerseyController() {
        logger.info("Registration controller....");
        register(LibreriaController.class);
    }

}
