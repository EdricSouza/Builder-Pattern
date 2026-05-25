package com.ucsal;

import java.util.Map;

public class HttpRequestData {
    private String method;
    private String url;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

    /*
     * - Difícil saber a ordem correta dos argumentos;
     * - Valores podem ser null;
     * - Código fica pouco legível;
     * */
    public HttpRequestData(String method, String url, Map<String, String> headers, Map<String, String> queryParams,
                           String body, String contentType, String authorizationToken) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.queryParams = queryParams;
        this.body = body;
        this.contentType = contentType;
        this.authorizationToken = authorizationToken;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        return "HttpRequestData{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", contentType='" + contentType + '\'' +
                ", authorizationToken='" + authorizationToken + '\'' +
                '}';
    }
}
