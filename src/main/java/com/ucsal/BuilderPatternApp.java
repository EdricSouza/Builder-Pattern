package com.ucsal;

import com.ucsal.facade.HttpFacade;
import com.ucsal.http.HttpRequest;
import com.ucsal.http.builder.HttpRequestBuilder;
import com.ucsal.http.client.HttpClient;

import java.net.http.HttpResponse;

public class BuilderPatternApp {

    static void main(String[] args) {

        HttpFacade http = new HttpFacade();

        System.out.println("### GET USERS ###");
        HttpResponse<String> response = http.get("https://jsonplaceholder.typicode.com/users");
        printResponse(response);

        System.out.println("\n### POST ###");
        response = http.postJson(
            "https://jsonplaceholder.typicode.com/posts",
            """
            {
                "title": "Builder Pattern",
                "body": "Teste de POST",
                "userId": 1
            }
            """
        );
        printResponse(response);

        System.out.println("\n### PUT ###");
        HttpRequest putRequest = new HttpRequestBuilder()
            .method("PUT")
            .url("https://jsonplaceholder.typicode.com/posts/1")
            .contentType("application/json")
            .body("""
            {
                "id": 1,
                "title": "Atualizado",
                "body": "Conteúdo atualizado",
                "userId": 1
            }
            """).build();

        HttpClient client = new HttpClient();
        response = client.send(putRequest);
        printResponse(response);
    }

    private static void printResponse(HttpResponse<String> response) {
        System.out.println("Status: " + response.statusCode());
        System.out.println("Response: " + response.body());
        System.out.println("-".repeat(60));
    }
}