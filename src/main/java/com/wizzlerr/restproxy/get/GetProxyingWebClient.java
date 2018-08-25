package com.wizzlerr.restproxy.get;

import com.wizzlerr.restproxy.stereotype.RestClient;
import com.wizzlerr.restproxy.util.UriResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestClient
@Slf4j
public class GetProxyingWebClient {

    private final WebClient webClient;

    public GetProxyingWebClient(@Value("${rest.proxy.basic.url}") String basicUrl) {
        webClient = WebClient.create(basicUrl);
    }

    public Mono<String> get(final ServerHttpRequest request) {
        return webClient.get()
                .uri(uriBuilder -> UriResolver.resolveUri(uriBuilder, request))
                .retrieve()
                .bodyToMono(String.class);
    }
}
