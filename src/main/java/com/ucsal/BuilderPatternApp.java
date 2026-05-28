package com.ucsal;

import java.util.Map;

import com.ucsal.HttpRequest.HttpRequest;
import com.ucsal.HttpRequest.HttpRequestBuilder;

public class BuilderPatternApp {

    /*
     * O problema principal dessa abordagem é que o construtor fica grande, cheio de null,
     * e a criação do objeto se torna pouco clara.
     * */
    static void main() {

        HttpRequest requestGet = new HttpRequestBuilder()
                .Method("GET")
                .Url("https://api.ucsal.com/alunos")
                .QueryParameters(Map.of("status", "ativo"))
                .AuthorizationToken("Bearer token123")
                .build();
    }

}