package com.github.mroose.integration.http.mapper.request;

import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.List;
import java.util.Map;

public class JdkHttpRequestMapper implements HttpRequestMapper<HttpRequest> {

    private JdkHttpRequestMapper() {
    }

    private static final class InstanceHolder {
        private static final JdkHttpRequestMapper INSTANCE = new JdkHttpRequestMapper();
    }

    public static JdkHttpRequestMapper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public HttpRequest mapRequest(com.github.mroose.integration.http.domain.HttpRequest httpRequest) {
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder()
                .uri(uriMap(httpRequest.getUrl(), httpRequest.getQueries()))
                .method(httpRequest.getHttpMethod().name(), bodyMap(httpRequest.getBody()));

        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            httpRequest.getHeaders().forEach((headerName, headerValues) ->
                    headerValues.forEach(headerValue ->
                            httpRequestBuilder.header(headerName, headerValue)));
        }

        return httpRequestBuilder.build();
    }

    private URI uriMap(String url, Map<String, List<String>> queries) {
        UriBuilder uriBuilder = UriBuilder.fromUri(url);

        if (queries != null && !queries.isEmpty()) {
            queries.forEach((k, v) -> uriBuilder.queryParam(k, v.toArray()));
        }

        return uriBuilder.build();
    }

    private BodyPublisher bodyMap(String body) {
        return (body != null && !body.isEmpty()) ? BodyPublishers.ofString(body) : BodyPublishers.noBody();
    }
}