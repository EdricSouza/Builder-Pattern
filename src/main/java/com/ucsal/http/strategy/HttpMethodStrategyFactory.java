package com.ucsal.http.strategy;

import com.ucsal.exception.HttpRequestBuildException;

import java.util.Map;

public class HttpMethodStrategyFactory {

    private static final Map<String, HttpMethodStrategy> STRATEGIES = Map.of(
            "GET",    new HttpMethodStrategies.GetStrategy(),
            "POST",   new HttpMethodStrategies.PostStrategy(),
            "PUT",    new HttpMethodStrategies.PutStrategy(),
            "DELETE", new HttpMethodStrategies.DeleteStrategy()
    );

    private HttpMethodStrategyFactory() {}

    public static HttpMethodStrategy of(String method) {
        HttpMethodStrategy strategy = STRATEGIES.get(method.toUpperCase());
        if (strategy == null) {
            throw new HttpRequestBuildException("Método HTTP não suportado: " + method);
        }
        return strategy;
    }
}