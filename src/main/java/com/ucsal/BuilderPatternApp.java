package com.ucsal;

import java.util.Map;

import com.ucsal.HttpRequest.HttpRequest;
import com.ucsal.HttpRequest.HttpRequestBuilder;

public class BuilderPatternApp {

    /*
     * Aplicando a chamada do padrão Builder nos objetos
     * */
    static void main() {

        HttpRequest requestGet = new HttpRequestBuilder()
                .method("GET")
                .url("https://api.ucsal.com/alunos")
                .queryParameters(Map.of("status", "ativo"))
                .authorizationToken("Bearer token123")
                .build();

                System.out.println(requestGet);

        HttpRequest requestPost = new HttpRequestBuilder()
                .method("POST")
                .url("https://api.ucsal.com/alunos")
                .header(Map.of("Accept", "application/json"))
                .queryParameters(Map.of("status", "ativo"))
                .body( "{\"nome\":\"João\"}")
                .authorizationToken("Bearer token123")
                .contentType("application/json")
                .authorizationToken("Bearer token123")
                .build();

                System.out.println(requestPost);

        HttpRequest requestPut = new HttpRequestBuilder()
                .method("GET")
                .url("https://api.ucsal.com/alunos")
                .queryParameters(Map.of("status", "ativo"))
                .authorizationToken("Bearer token123")
                .build();

                System.out.println(requestPut);
    }
}
