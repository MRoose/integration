package com.github.mroose.integration.http.core.domain;

import com.github.mroose.integration.http.core.builder.HttpResponseBuilder;

import java.util.List;
import java.util.Map;

public class HttpResponse {

    private Integer statusCode;
    private Map<String, List<String>> headers;
    private String body;

    public static HttpResponseBuilder builder() {
        return new HttpResponseBuilder();
    }

    public HttpResponse(Integer statusCode, Map<String, List<String>> headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}