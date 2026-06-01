package com.ucsal;

import java.util.Map;

import com.ucsal.HttpRequest.HttpRequestData;
import com.ucsal.HttpRequest.HttpRequestBuilder;

public class BuilderPatternApp {

    /*
     * Aplicando a chamada do padrão Builder nos objetos
     * */
    static void main() {

        HttpRequestData requestGet = new HttpRequestBuilder()
                .method("GET")
                .url("https://api.ucsal.com/alunos")
                .queryParameters(Map.of("status", "ativo"))
                .authorizationToken("Bearer token123")
                .build();
        
                System.out.println("### GET - ALUNOS ###");
                System.out.println(getAlunos(requestGet));

        HttpRequestData requestPost = new HttpRequestBuilder()
                .method("POST")
                .url("https://api.ucsal.com/alunos")
                .header(Map.of("Accept", "application/json"))
                .queryParameters(Map.of("status", "ativo"))
                .body( "{\"nome\":\"João\"}")
                .authorizationToken("Bearer token123")
                .contentType("application/json")
                .build();

                System.out.println("### POST - ALUNOS ###");
                System.out.println(createAluno(requestPost));

        HttpRequestData requestPut = new HttpRequestBuilder()
                .method("GET")
                .url("https://api.ucsal.com/alunos")
                .queryParameters(Map.of("status", "ativo"))
                .authorizationToken("Bearer token123")
                .build();

                System.out.println("### PUT - ALUNOS ###");
                System.out.println(updateAluno(requestPut));
    }

    static String getAlunos(HttpRequestData req) {
        String filtroStatus = req.getQueryParams() != null
                ? req.getQueryParams().getOrDefault("status", "todos")
                : "todos";

        return """
                {
                  "filtro": { "status": "%s" },
                  "alunos": [
                    { "id": 1, "nome": "João Silva",  "matricula": "2023001", "status": "ativo" },
                    { "id": 2, "nome": "Maria Souza", "matricula": "2023002", "status": "ativo" }
                  ]
                }
                """.formatted(filtroStatus);
    }

    static String createAluno(HttpRequestData req) {
        return """
                {
                  "id": 4,
                  "body_recebido": %s,
                  "status": "ativo",
                  "criadoEm": "2026-05-29T10:30:00Z"
                }
                """.formatted(req.getBody());
    }

    static String updateAluno(HttpRequestData req) {
        String id = req.getUrl().substring(req.getUrl().lastIndexOf('/') + 1);
        return """
                {
                  "id": %s,
                  "body_recebido": %s,
                  "atualizadoEm": "2026-05-29T10:35:00Z"
                }
                """.formatted(id, req.getBody());
    }
}