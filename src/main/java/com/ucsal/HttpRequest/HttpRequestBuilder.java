package com.ucsal.HttpRequest;

import java.net.http.HttpResponse;
import java.util.Map;

import com.ucsal.Interface.IHttpRequestBuilder;

public class HttpRequestBuilder implements IHttpRequestBuilder {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

    @Override
    public IHttpRequestBuilder Url(String url) {
        this.url = url;
        return this;
    }
    @Override
    public IHttpRequestBuilder Method(String method) {
        this.method = method;
        return this;
    }
    @Override
    public IHttpRequestBuilder Header(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    @Override
    public IHttpRequestBuilder QueryParameters(Map<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }
    @Override
    public IHttpRequestBuilder Body(String body) {
        this.body = body;
        return this;
    }
    @Override
	public IHttpRequestBuilder ContentType(String contentType) {
		this.contentType = contentType;
        return this;
	}
    @Override
	public IHttpRequestBuilder AuthorizationToken(String authorizationToken) {
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
