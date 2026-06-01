package com.ucsal;

import com.ucsal.HttpRequest.HttpRequestData;

import java.net.http.HttpResponse;

import com.ucsal.HttpRequest.HttpRequestBuilder;

public class BuilderPatternApp {

    /*
     * Aplicando a chamada do padrão Builder nos objetos
     * */
    public static void main(String[] args) {

    try {
        HttpRequestData requestGet = new HttpRequestBuilder()
                .method("GET")
                .url("https://jsonplaceholder.typicode.com/users")
                .build();

        System.out.println("### GET USERS ###");
        HttpResponse<String> response = requestGet.send();

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        HttpRequestData requestPost = new HttpRequestBuilder()
                .method("POST")
                .url("https://jsonplaceholder.typicode.com/posts")
                .contentType("application/json")
                .body("""
                    {
                        "title":"Builder Pattern",
                        "body":"Teste de POST",
                        "userId":1
                    }
                    """)
                .build();

        System.out.println("____________________________________________________________");

        System.out.println("### POST ###");
        response = requestPost.send();
        
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        HttpRequestData requestPut = new HttpRequestBuilder()
                .method("PUT")
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .contentType("application/json")
                .body("""
                    {
                        "id":1,
                        "title":"Atualizado",
                        "body":"Conteúdo atualizado",
                        "userId":1
                    }
                    """)
                .build();

        System.out.println("____________________________________________________________");

        System.out.println("### PUT ###");
        System.out.println(requestPut.send());
        response = requestPost.send();
        
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}