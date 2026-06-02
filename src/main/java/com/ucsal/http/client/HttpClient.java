package com.ucsal.http.client;

import com.ucsal.exception.HttpRequestException;
import com.ucsal.http.HttpRequest;
import com.ucsal.http.strategy.HttpMethodStrategy;
import com.ucsal.http.strategy.HttpMethodStrategyFactory;

import java.net.URI;
import java.net.http.HttpResponse;

public class HttpClient {

    private final java.net.http.HttpClient nativeClient;

    public HttpClient() {
        this.nativeClient = java.net.http.HttpClient.newHttpClient();
    }

    public HttpClient(java.net.http.HttpClient nativeClient) {
        this.nativeClient = nativeClient;
    }

    public HttpResponse<String> send(HttpRequest request) {
        try {
            String finalUrl = buildUrl(request);

            java.net.http.HttpRequest.Builder nativeBuilder =
                    java.net.http.HttpRequest.newBuilder()
                            .uri(URI.create(finalUrl));

            applyHeaders(nativeBuilder, request);

            HttpMethodStrategy strategy = HttpMethodStrategyFactory.of(request.method());
            strategy.apply(nativeBuilder, request.body());

            return nativeClient.send(
                    nativeBuilder.build(),
                    HttpResponse.BodyHandlers.ofString()
            );

        } catch (Exception e) {
            throw new HttpRequestException("Erro ao executar requisição HTTP: " + e.getMessage(), e);
        }
    }

    private void applyHeaders(java.net.http.HttpRequest.Builder builder, HttpRequest request) {
        request.headers().forEach(builder::header);

        if (request.contentType() != null) {
            builder.header("Content-Type", request.contentType());
        }

        if (request.authorizationToken() != null) {
            builder.header("Authorization", request.authorizationToken());
        }
    }

    private String buildUrl(HttpRequest request) {
        if (request.queryParams().isEmpty()) {
            return request.url();
        }

        StringBuilder sb = new StringBuilder(request.url()).append("?");

        request.queryParams().forEach((key, value) ->
                sb.append(key).append("=").append(value).append("&")
        );

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}