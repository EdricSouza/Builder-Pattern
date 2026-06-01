package com.ucsal.HttpRequest;

import java.net.http.HttpResponse;
import java.util.Map;

public class HttpRequestData {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

    public HttpRequestData(
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

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", contentType='" + contentType + '\'' +
                ", authorizationToken='" + authorizationToken + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }
}
