package com.wizzlerr.restproxy.delete;

import com.wizzlerr.restproxy.stereotype.RestClient;
import com.wizzlerr.restproxy.util.UriResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestClient
public class DeleteProxyingWebClient {

    private final WebClient webClient;

    public DeleteProxyingWebClient(@Value("${rest.proxy.basic.url}") String basicUrl) {
        webClient = WebClient.create(basicUrl);
    }

    public Mono<String> delete(final ServerHttpRequest request) {
        return webClient.delete()
                .uri(uriBuilder -> UriResolver.resolveUri(uriBuilder, request))
                .retrieve()
                .bodyToMono(String.class);
    }
}
