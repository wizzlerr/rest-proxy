package com.wizzlerr.restproxy.router;

import com.wizzlerr.restproxy.stereotype.Router;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Router
public class ExternalRouter {

    public Mono<ServerResponse> route(final ServerRequest serverRequest) {
        log.info("Routing request {}", serverRequest);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject("Hello World!"));
    }
}
