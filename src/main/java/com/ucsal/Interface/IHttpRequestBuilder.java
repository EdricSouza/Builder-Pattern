package com.ucsal.Interface;

import java.util.Map;

import com.ucsal.HttpRequest.HttpRequestData;

public interface IHttpRequestBuilder {
    IHttpRequestBuilder url (String url);
    IHttpRequestBuilder method (String method);
    IHttpRequestBuilder header (Map<String, String> headers);
    IHttpRequestBuilder queryParameters (Map<String, String> queryParams);
    IHttpRequestBuilder body (String body);
    IHttpRequestBuilder contentType (String contentType);
    IHttpRequestBuilder authorizationToken (String authorizationToken);
    HttpRequestData build();
}
