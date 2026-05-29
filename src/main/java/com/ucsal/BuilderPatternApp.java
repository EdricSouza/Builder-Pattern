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

        System.out.println("### GET - ALUNOS ###");
        System.out.println(getAlunos(requestGet));

        HttpRequestData requestPost = new HttpRequestData(
                "POST",
                "https://api.ucsal.com/alunos",
                Map.of("Accept", "application/json"),
                null,
                "{\"nome\":\"João\"}",
                "application/json",
                "Bearer token123"
        );

        System.out.println("### POST - ALUNOS ###");
        System.out.println(createAluno(requestPost));

        HttpRequestData requestPut = new HttpRequestData(
                "PUT",
                "https://api.ucsal.com/alunos/1",
                Map.of("Accept", "application/json"),
                null,
                "{\"nome\":\"João Atualizado\"}",
                "application/json",
                "Bearer token123"
        );

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