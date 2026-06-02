package com.ucsal.facade;

import com.ucsal.http.HttpRequest;
import com.ucsal.http.builder.HttpRequestBuilder;
import com.ucsal.http.client.HttpClient;

import java.net.http.HttpResponse;
import java.util.Map;

public class HttpFacade {

    private final HttpClient client;

    public HttpFacade() {
        this.client = new HttpClient();
    }

    public HttpResponse<String> get(String url) {
        HttpRequest request = new HttpRequestBuilder()
                .url(url)
                .method("GET")
                .build();
        return client.send(request);
    }

    public HttpResponse<String> get(String url, Map<String, String> queryParams) {
        HttpRequest request = new HttpRequestBuilder()
                .url(url)
                .method("GET")
                .queryParams(queryParams)
                .build();
        return client.send(request);
    }

    public HttpResponse<String> postJson(String url, String jsonBody) {
        HttpRequest request = new HttpRequestBuilder()
                .url(url)
                .method("POST")
                .contentType("application/json")
                .body(jsonBody)
                .build();
        return client.send(request);
    }

    public HttpResponse<String> putJson(String url, String jsonBody) {
        HttpRequest request = new HttpRequestBuilder()
                .url(url)
                .method("PUT")
                .contentType("application/json")
                .body(jsonBody)
                .build();
        return client.send(request);
    }

    public HttpResponse<String> delete(String url) {
        HttpRequest request = new HttpRequestBuilder()
                .url(url)
                .method("DELETE")
                .build();
        return client.send(request);
    }

    public HttpResponse<String> send(HttpRequest request) {
        return client.send(request);
    }
}