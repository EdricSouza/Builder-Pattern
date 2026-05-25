package com.ucsal;

import java.util.Map;

public class BuilderPatternApp {

    /*
     * O problema principal dessa abordagem é que o construtor fica grande, cheio de null,
     * e a criação do objeto se torna pouco clara.
     * */
    static void main() {

        HttpRequestData requestGet = new HttpRequestData(
                "GET",
                "https://api.ucsal.com/alunos",
                null,
                Map.of("status", "ativo"),
                null,
                null,
                "Bearer token123"
        );

        System.out.println(requestGet);

        HttpRequestData requestPost = new HttpRequestData(
                "POST",
                "https://api.ucsal.com/alunos",
                Map.of("Accept", "application/json"),
                null,
                "{\"nome\":\"João\"}",
                "application/json",
                "Bearer token123"
        );

        System.out.println(requestPost);

        HttpRequestData requestPut = new HttpRequestData(
                "PUT",
                "https://api.ucsal.com/alunos/1",
                Map.of("Accept", "application/json"),
                null,
                "{\"nome\":\"João Atualizado\"}",
                "application/json",
                "Bearer token123"
        );

        System.out.println(requestPut);

    }

}