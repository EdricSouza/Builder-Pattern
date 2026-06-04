package com.ucsal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    public HttpResponse<String> send () {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String finalUrl = buildUrl();

            HttpRequest.Builder requestBuilder =
                    HttpRequest.newBuilder()
                            .uri(URI.create(finalUrl));

            if (headers != null) {
                headers.forEach(requestBuilder::header);
            }

            if (contentType != null) {
                requestBuilder.header("Content-Type", contentType);
            }

            if (authorizationToken != null) {
                requestBuilder.header("Authorization", authorizationToken);
            }

            switch (method.toUpperCase()) {

                case "GET":
                    requestBuilder.GET();
                    break;

                case "POST":
                    requestBuilder.POST(
                            HttpRequest.BodyPublishers.ofString(
                                    body != null ? body : ""));
                    break;

                case "PUT":
                    requestBuilder.PUT(
                            HttpRequest.BodyPublishers.ofString(
                                    body != null ? body : ""));
                    break;

                case "DELETE":
                    requestBuilder.DELETE();
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Método HTTP inválido: " + method);
            }

            return client.send(
                    requestBuilder.build(),
                    HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar requisição", e);
        }
    }

    private String buildUrl() {
        if (queryParams == null || queryParams.isEmpty()) {
            return url;
        }

        StringBuilder sb = new StringBuilder(url);
        sb.append("?");

        queryParams.forEach((key, value) ->
            sb.append(key)
            .append("=")
            .append(value)
            .append("&"));

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
