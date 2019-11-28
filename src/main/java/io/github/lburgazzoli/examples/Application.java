package io.github.lburgazzoli.examples;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    @Inject
    CamelContext context;

    void onStart(@Observes StartupEvent event) {
        LOGGER.info(
            "1. message = {}",
             ConfigProvider.getConfig().getOptionalValue("the.message", String.class).orElse(null)
        );
        LOGGER.info(
            "2. message = {}",
             context.resolvePropertyPlaceholders("{{the.message}}")
        );
    }
}