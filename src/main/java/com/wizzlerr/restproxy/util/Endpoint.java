package com.wizzlerr.restproxy.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Endpoint {

    API_ENDPOINT("/api");

    public static final String API_ENDPOINT_VALUE = "/api/**";

    private final String value;

}
