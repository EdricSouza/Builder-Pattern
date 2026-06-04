package com.ucsal;

import java.net.http.HttpResponse;
import java.util.Map;

public class BuilderPatternApp {
    /*
     * Aplicando o padrão Reflection
     */
    public static void main(String[] args) {

        // ### GET ###
        HttpRequestData requestGet = new ReflectiveBuilder<>(HttpRequestData.class)
                .with("method", "GET")
                .with("url", "https://jsonplaceholder.typicode.com/users")
                .with("authorizationToken", "Bearer token123")
                .build();

        System.out.println("### GET - ALUNOS ###");
        HttpResponse<String> response = requestGet.send();

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        System.out.println("____________________________________________________________");

        // ### POST ###
        HttpRequestData requestPost = new ReflectiveBuilder<>(HttpRequestData.class)
                .with("method", "POST")
                .with("url", "https://jsonplaceholder.typicode.com/users")
                .with("body",
                 """
                    {
                        "title":"Builder Pattern",
                        "body":"Teste de POST",
                        "userId":1
                    }
                    """)
                .with("contentType", "application/json")
                .with("authorizationToken", "Bearer token123")
                .build();

        System.out.println("### POST - ALUNOS ###");
        response = requestPost.send();

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        System.out.println("____________________________________________________________");

        // ### PUT ###
        HttpRequestData requestPut = new ReflectiveBuilder<>(HttpRequestData.class)
                .with("method", "PUT")
                .with("url", "https://jsonplaceholder.typicode.com/users/1")
                .with("body", """
                    {
                        "id":1,
                        "title":"Atualizado",
                        "body":"Conteúdo atualizado",
                        "userId":1
                    }
                    """)
                .with("contentType", "application/json")
                .with("authorizationToken", "Bearer token123")
                .build();

        System.out.println("### PUT - ALUNOS ###");
        System.out.println(requestPut.send());
        response = requestPut.send();
        
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }
}