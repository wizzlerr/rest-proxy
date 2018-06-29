package com.wizzlerr.restproxy.router;

import com.wizzlerr.restproxy.stereotype.Router;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Router
public class ExternalRouter {

    public Mono<ServerResponse> route(final ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject("Hello World!"));
    }
}
