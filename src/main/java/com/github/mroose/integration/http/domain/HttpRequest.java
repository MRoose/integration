package com.github.mroose.integration.http.domain;

import com.github.mroose.integration.http.builder.HttpRequestBuilder;

import java.util.List;
import java.util.Map;

public class HttpRequest {

    private HttpMethod httpMethod;
    private String url;
    private Map<String, List<String>> headers;
    private Map<String, List<String>> queries;
    private String body;

    public static HttpRequestBuilder builder() {
        return new HttpRequestBuilder();
    }

    public HttpRequest(HttpMethod httpMethod, String url, Map<String, List<String>> headers, Map<String, List<String>> queries, String body) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.headers = headers;
        this.queries = queries;
        this.body = body;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Map<String, List<String>> getQueries() {
        return queries;
    }

    public void setQueries(Map<String, List<String>> queries) {
        this.queries = queries;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}