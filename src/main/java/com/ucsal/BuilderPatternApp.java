package com.ucsal;

import java.sql.Ref;
import java.util.Map;

public class BuilderPatternApp {

    /*
     * Aplicando o padrao Reflection
     * */
    static void main() {


        HttpRequestData requestGet = new ReflectiveBuilder<>(HttpRequestData.class)
                .with("method","GET")
                .with("url","https://api.ucsal.com/alunos")
                .with("queryParams",Map.of("status", "ativo"))
                .with("authorizationToken","Bearer token123").build();

        System.out.println("### GET - ALUNOS ###");

        HttpRequest requestPost = new ReflectiveBuilder<>(HttpRequestData.class)
                .method("POST")
                .url("https://api.ucsal.com/alunos")
                .header(Map.of("Accept", "application/json"))
                .queryParameters(Map.of("status", "ativo"))
                .body( "{\"nome\":\"João\"}")
                .authorizationToken("Bearer token123")
                .contentType("application/json")
                .authorizationToken("Bearer token123")
                .build();

                System.out.println("### POST - ALUNOS ###");

        HttpRequest requestPut = ReflectiveBuilder<>(HttpRequestData.class)
                .method("GET")
                .url("https://api.ucsal.com/alunos")
                .queryParameters(Map.of("status", "ativo"))
                .authorizationToken("Bearer token123")
                .build();

                System.out.println("### PUT - ALUNOS ###");
    }
}
