package com.ucsal;

import java.util.Map;

public class HttpRequestData {
    private String method;
    private String url;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String contentType;
    private String authorizationToken;

}
