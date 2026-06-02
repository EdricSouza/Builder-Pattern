package com.ucsal.http;

import java.util.Collections;
import java.util.Map;

public record HttpRequest(String url, String method, Map<String, String> headers, Map<String, String> queryParams,
                          String body, String contentType, String authorizationToken) {

    public HttpRequest(
            String url,
            String method,
            Map<String, String> headers,
            Map<String, String> queryParams,
            String body,
            String contentType,
            String authorizationToken
    ) {
        this.url = url;
        this.method = method;
        this.headers = headers != null ? Collections.unmodifiableMap(headers) : Collections.emptyMap();
        this.queryParams = queryParams != null ? Collections.unmodifiableMap(queryParams) : Collections.emptyMap();
        this.body = body;
        this.contentType = contentType;
        this.authorizationToken = authorizationToken;
    }

}