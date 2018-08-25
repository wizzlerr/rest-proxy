package com.wizzlerr.restproxy.delete;

import com.wizzlerr.restproxy.util.Endpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class DeleteProxyingController {

    private final DeleteProxyingWebClient deleteProxyingWebClient;

    public DeleteProxyingController(DeleteProxyingWebClient deleteProxyingWebClient) {
        this.deleteProxyingWebClient = deleteProxyingWebClient;
    }

    @DeleteMapping(value = Endpoint.API_ENDPOINT_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> proxyDelete(final ServerWebExchange webExchange) {
        return deleteProxyingWebClient.delete(webExchange.getRequest());
    }
}
