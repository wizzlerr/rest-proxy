package com.wizzlerr.restproxy.post;

import com.wizzlerr.restproxy.util.Endpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class PostProxyingController {

    private final PostProxyingWebClient postProxyingWebClient;

    public PostProxyingController(PostProxyingWebClient postProxyingWebClient) {
        this.postProxyingWebClient = postProxyingWebClient;
    }

    @PostMapping(value = Endpoint.API_ENDPOINT_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> proxyPost(final ServerWebExchange webExchange, @RequestBody final String body) {
        return postProxyingWebClient.post(webExchange.getRequest(), body);
    }

}
