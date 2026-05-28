package com.ucsal.HttpRequest;

import java.net.http.HttpResponse;
import java.util.Map;

public class HttpRequest {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

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
        this.headers = headers;
        this.queryParams = queryParams;
        this.body = body;
        this.contentType = contentType;
        this.authorizationToken = authorizationToken;
    }

    public HttpResponse send () {
        throw new UnsupportedOperationException("Sem implementação real");
    }
}
