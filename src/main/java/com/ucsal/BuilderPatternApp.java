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

        System.out.println(requestGet);


    }

}