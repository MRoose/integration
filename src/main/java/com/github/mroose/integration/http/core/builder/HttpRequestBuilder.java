package com.github.mroose.integration.http.core.builder;

import com.github.mroose.integration.http.core.domain.HttpMethod;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestBuilder {

    private JsonUtil jsonUtil;

    private HttpMethod httpMethod;
    private String url;
    private Map<String, List<String>> headers = new HashMap<>();
    private Map<String, List<String>> queries = new HashMap<>();
    private String body;

    public HttpRequestBuilder() {
        this.jsonUtil = JsonUtil.getInstance();
    }

    public HttpRequestBuilder httpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public HttpRequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public HttpRequestBuilder header(String name, String value) {
        if (this.headers.containsKey(name)) {
            this.headers.get(name).add(value);
        } else {
            this.headers.put(name, List.of(value));
        }
        return this;
    }

    public HttpRequestBuilder headers(Map<String, List<String>> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public HttpRequestBuilder query(String name, String value) {
        if (this.queries.containsKey(name)) {
            this.queries.get(name).add(value);
        } else {
            this.queries.put(name, List.of(value));
        }
        return this;
    }

    public HttpRequestBuilder queries(Map<String, List<String>> queries) {
        this.queries.putAll(queries);
        return this;
    }

    public HttpRequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder body(Map<String, String> body) {
        this.body = jsonUtil.serialize(body);
        return this;
    }

    public HttpRequestBuilder body(Object body) {
        this.body = jsonUtil.serialize(body);
        return this;
    }

    public HttpRequest build() {
        return new HttpRequest(httpMethod, url, headers, queries, body);
    }
}