package com.wizzlerr.restproxy.util;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

public final class UriResolver {

    private UriResolver() {
        throw new IllegalStateException("Cannot init utility class");
    }

    public static final URI resolveUri(final UriBuilder uriBuilder, final ServerHttpRequest request) {
        return uriBuilder.path(resolvePath(request)).queryParams(request.getQueryParams()).build();
    }

    public static final String resolvePath(final ServerHttpRequest request) {
        return request.getPath().pathWithinApplication().value().replace(Endpoint.API_ENDPOINT.getValue(), "");
    }
}
