package com.github.mroose.integration.http.core.builder;

import com.github.mroose.integration.http.core.domain.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseBuilder {

    private Integer statusCode;
    private Map<String, List<String>> headers = new HashMap<>();
    private String body;

    public HttpResponseBuilder statusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseBuilder statusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseBuilder header(String name, String value) {
        if (this.headers.containsKey(name)) {
            this.headers.get(name).add(value);
        } else {
            this.headers.put(name, List.of(value));
        }
        return this;
    }

    public HttpResponseBuilder headers(Map<String, List<String>> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public HttpResponseBuilder body(String body) {
        this.body = body;
        return this;
    }

    public HttpResponse build() {
        return new HttpResponse(statusCode, headers, body);
    }
}