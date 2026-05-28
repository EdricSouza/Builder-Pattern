package com.ucsal.Interface;

import java.util.Map;

import com.ucsal.HttpRequest.HttpRequest;

public interface IHttpRequestBuilder {
    public IHttpRequestBuilder Url (String url);
    public IHttpRequestBuilder Method (String method);
    public IHttpRequestBuilder Header (Map<String, String> headers);
    public IHttpRequestBuilder QueryParameters (Map<String, String> queryParams);
    public IHttpRequestBuilder Body (String body);
    public IHttpRequestBuilder ContentType (String contentType);
    public IHttpRequestBuilder AuthorizationToken (String authorizationToken);
    
    public HttpRequest build();
}
