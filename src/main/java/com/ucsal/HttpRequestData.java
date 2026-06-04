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

