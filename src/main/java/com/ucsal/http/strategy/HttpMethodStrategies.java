package com.ucsal.http.strategy;

import java.net.http.HttpRequest;

public final class HttpMethodStrategies {

    private HttpMethodStrategies() {}

    public static class GetStrategy implements HttpMethodStrategy {
        @Override
        public void apply(HttpRequest.Builder builder, String body) {
            builder.GET();
        }
    }

    public static class PostStrategy implements HttpMethodStrategy {
        @Override
        public void apply(HttpRequest.Builder builder, String body) {
            builder.POST(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
        }
    }

    public static class PutStrategy implements HttpMethodStrategy {
        @Override
        public void apply(HttpRequest.Builder builder, String body) {
            builder.PUT(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
        }
    }

    public static class DeleteStrategy implements HttpMethodStrategy {
        @Override
        public void apply(HttpRequest.Builder builder, String body) {
            builder.DELETE();
        }
    }
}