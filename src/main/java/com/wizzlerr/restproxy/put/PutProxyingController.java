package com.wizzlerr.restproxy.put;

import com.wizzlerr.restproxy.util.Endpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class PutProxyingController {

    private final PutProxyingWebClient putProxyingWebClient;

    public PutProxyingController(PutProxyingWebClient putProxyingWebClient) {
        this.putProxyingWebClient = putProxyingWebClient;
    }

    @PutMapping(value = Endpoint.API_ENDPOINT_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> proxyPut(final ServerWebExchange webExchange, @RequestBody final String body) {
        return putProxyingWebClient.put(webExchange.getRequest(), body);
    }

}
