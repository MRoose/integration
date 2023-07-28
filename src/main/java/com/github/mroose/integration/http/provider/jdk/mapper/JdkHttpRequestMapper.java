package com.github.mroose.integration.http.provider.jdk.mapper;

import com.github.mroose.integration.http.core.mapper.HttpRequestMapper;
import jakarta.ws.rs.core.UriBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdkHttpRequestMapper implements HttpRequestMapper {

    @Override
    public HttpRequest map(com.github.mroose.integration.http.core.domain.HttpRequest httpRequest) {
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder();

        if (httpRequest.getHeaders() != null && httpRequest.getHeaders().isEmpty()) {
            httpRequest.getHeaders().forEach((headerName, headerValues) ->
                    headerValues.forEach(headerValue ->
                            httpRequestBuilder.header(headerName, headerValue)));
        }

        String queries = httpRequest.getQueries().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> entry.getKey() + "=" + value))
                .collect(Collectors.joining("&"));

        if (!queries.isEmpty()) {
            try {
                httpRequestBuilder.uri(new URI(httpRequest.getUrl() + "?" + queries));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        return httpRequestBuilder.build();
    }

    private URI getURI(String url, Map<String, String> queries) {
        UriBuilder uriBuilder = UriBuilder.fromUri(url);

        if (queries != null) {
            queries.forEach(uriBuilder::queryParam);
        }

        return uriBuilder.build();
    }

    private String[] headerMap(Map<String, List<String>> headers) {

        if (headers == null || headers.isEmpty()) {
            return null;
        }

        return headers.entrySet().stream()
                .flatMap(entry -> Stream.concat(Stream.of(entry.getKey()), entry.getValue().stream()))
                .toArray(String[]::new);
    }

    private String queryMap(Map<String, List<String>> queries) {

        if (queries == null || queries.isEmpty()) {
            return null;
        }

        return queries.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> entry.getKey() + "=" + value))
                .collect(Collectors.joining("&"));
    }

    private BodyPublisher bodyMap(String body) {
        return (body != null && !body.isEmpty()) ? BodyPublishers.ofString(body) : BodyPublishers.noBody();
    }
}