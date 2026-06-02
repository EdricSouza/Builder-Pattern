package com.ucsal.http.builder;

import com.ucsal.http.HttpRequest;

import java.util.Map;

public interface IHttpRequestBuilder {
    IHttpRequestBuilder url(String url);
    IHttpRequestBuilder method(String method);
    IHttpRequestBuilder headers(Map<String, String> headers);
    IHttpRequestBuilder queryParams(Map<String, String> queryParams);
    IHttpRequestBuilder body(String body);
    IHttpRequestBuilder contentType(String contentType);
    IHttpRequestBuilder authorizationToken(String token);

    HttpRequest build();
}