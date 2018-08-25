package com.wizzlerr.restproxy.put;

import com.wizzlerr.restproxy.stereotype.RestClient;
import com.wizzlerr.restproxy.util.UriResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestClient
@Slf4j
public class PutProxyingWebClient {

    private final WebClient webClient;

    public PutProxyingWebClient(@Value("${rest.proxy.basic.url}") String basicUrl) {
        webClient = WebClient.create(basicUrl);
    }

    public Mono<String> put(final ServerHttpRequest request, final String body) {
        return webClient.put()
                .uri(uriBuilder -> UriResolver.resolveUri(uriBuilder, request))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(body))
                .retrieve()
                .bodyToMono(String.class);
    }
}
