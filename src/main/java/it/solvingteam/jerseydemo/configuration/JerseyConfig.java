package it.solvingteam.jerseydemo.configuration;

import it.solvingteam.jerseydemo.controller.MathController;
import javax.annotation.PostConstruct;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    private final Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

    @PostConstruct
    public void registerJerseyController() {
        logger.info("Registration controller....");
        register(MathController.class);
    }

}
