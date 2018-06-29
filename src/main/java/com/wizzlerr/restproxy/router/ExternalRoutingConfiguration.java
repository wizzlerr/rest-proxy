package com.wizzlerr.restproxy.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ExternalRoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoExternalRouter(final ExternalRouter externalRouter) {
        return RouterFunctions.route(RequestPredicates.GET("/api/*").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), externalRouter::route);
    }
}
