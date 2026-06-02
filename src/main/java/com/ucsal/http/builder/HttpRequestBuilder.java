package com.ucsal.http.builder;

import com.ucsal.exception.HttpRequestBuildException;
import com.ucsal.http.HttpRequest;

import java.util.Map;

public class HttpRequestBuilder implements IHttpRequestBuilder {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

    @Override
    public IHttpRequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public IHttpRequestBuilder method(String method) {
        this.method = method;
        return this;
    }

    @Override
    public IHttpRequestBuilder headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public IHttpRequestBuilder queryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    @Override
    public IHttpRequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public IHttpRequestBuilder contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    @Override
    public IHttpRequestBuilder authorizationToken(String token) {
        this.authorizationToken = token;
        return this;
    }

    @Override
    public HttpRequest build() {
        validate();
        return new HttpRequest(url, method, headers, queryParams, body, contentType, authorizationToken);
    }

    private void validate() {
        if (url == null || url.isBlank()) {
            throw new HttpRequestBuildException("URL é obrigatória.");
        }
        if (method == null || method.isBlank()) {
            throw new HttpRequestBuildException("Método HTTP é obrigatório.");
        }

        String upperMethod = method.toUpperCase();
        if (!upperMethod.equals("GET") &&
                !upperMethod.equals("POST") &&
                !upperMethod.equals("PUT") &&
                !upperMethod.equals("DELETE")) {
            throw new HttpRequestBuildException("Método HTTP inválido: " + method);
        }

        boolean hasBody = body != null && !body.isBlank();
        if ((upperMethod.equals("POST") || upperMethod.equals("PUT")) && !hasBody) {
            // Permite body vazio para compatibilidade — apenas aviso implícito
        }
    }
}