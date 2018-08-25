package com.wizzlerr.restproxy.get;

import com.wizzlerr.restproxy.util.Endpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class GetProxyingController {

    private final GetProxyingWebClient getProxyingWebClient;

    public GetProxyingController(GetProxyingWebClient getProxyingWebClient) {
        this.getProxyingWebClient = getProxyingWebClient;
    }

    @GetMapping(value = Endpoint.API_ENDPOINT_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> proxyGet(final ServerWebExchange webExchange) {
        return getProxyingWebClient.get(webExchange.getRequest());
    }

}
