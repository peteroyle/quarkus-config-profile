package io.github.lburgazzoli.examples;

import org.apache.camel.builder.RouteBuilder;

public class ApplicationRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:conf")
            .log("{{the.message}}");
    }
}