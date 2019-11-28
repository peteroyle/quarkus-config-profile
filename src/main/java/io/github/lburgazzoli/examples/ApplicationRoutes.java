package io.github.lburgazzoli.examples;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class ApplicationRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:conf")
            .log("{{the.message}}");
    }
}