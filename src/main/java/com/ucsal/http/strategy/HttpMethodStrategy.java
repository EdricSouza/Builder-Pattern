package com.ucsal.http.strategy;

import java.net.http.HttpRequest;

public interface HttpMethodStrategy {
    void apply(HttpRequest.Builder builder, String body);
}