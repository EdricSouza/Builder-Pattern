package com.ucsal;

import java.net.http.HttpResponse;
import java.util.Map;

public class BuilderPatternApp {

    /*
     * O problema principal dessa abordagem é que o construtor fica grande, cheio de null,
     * e a criação do objeto se torna pouco clara.
     * */
    public static void main(String[] args) {

        HttpRequestData requestGet = new HttpRequestData(
                "GET",
                "https://jsonplaceholder.typicode.com/users",
                null,
                Map.of("status", "ativo"),
                null,
                null,
                "Bearer token123"
        );

        System.out.println("### GET - ALUNOS ###");
        HttpResponse<String> response = requestGet.send();

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        System.out.println("________________________________________________");

        HttpRequestData requestPost = new HttpRequestData(
                "POST",
                "https://jsonplaceholder.typicode.com/posts",
                null,
                null,
                "{\"title\":\"Builder Pattern\",\"body\":\"Teste de POST\",\"userId\":1}",
                "application/json",
                "Bearer token123"
        );

        System.out.println("### POST - ALUNOS ###");
        HttpResponse<String> responsePost = requestPost.send();
        System.out.println("Status: " + responsePost.statusCode());
        System.out.println("Body: " + responsePost.body());

        System.out.println("________________________________________________");

        HttpRequestData requestPut = new HttpRequestData(
                "PUT",
                "https://jsonplaceholder.typicode.com/posts/1",
                null,
                null,
                "{\"title\":\"João Atualizado\",\"body\":\"Conteúdo atualizado\",\"userId\":1}",
                "application/json",
                "Bearer token123"
        );

        System.out.println("### PUT - ALUNOS ###");
        HttpResponse<String> responsePut = requestPut.send();
        System.out.println("Status: " + responsePut.statusCode());
        System.out.println("Body: " + responsePut.body());

        System.out.println("________________________________________________");
    }
}