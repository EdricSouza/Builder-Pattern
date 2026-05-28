package com.ucsal.HttpRequest;

import com.ucsal.Interface.IHttpRequestBuilder;

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
    public IHttpRequestBuilder header(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    @Override
    public IHttpRequestBuilder queryParameters(Map<String, String> queryParams) {
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
	public IHttpRequestBuilder authorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
        return this;
	}
    @Override
    public HttpRequest build() {
        return new HttpRequest(
            url,
            method,
            headers,
            queryParams,
            body,
            contentType,
            authorizationToken
        );
    }

}
