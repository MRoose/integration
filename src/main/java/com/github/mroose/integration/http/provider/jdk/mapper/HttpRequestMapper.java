package com.github.mroose.integration.http.provider.jdk.mapper;

import com.github.mroose.integration.http.core.domain.HttpRequest;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.Map;

public class HttpRequestMapper {

    public static java.net.http.HttpRequest map(HttpRequest myHttpRequest) {

        java.net.http.HttpRequest.Builder javaHttpRequestBuilder = java.net.http.HttpRequest.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .timeout(Duration.ofSeconds(60))
            .uri(getURI(myHttpRequest.url(), myHttpRequest.queries()))
            .method(myHttpRequest.httpMethod().toString(), getRequestBodyPublisher(myHttpRequest));

        if (myHttpRequest.headers() != null) {
            myHttpRequest.headers().forEach(javaHttpRequestBuilder::header);
        }

        java.net.http.HttpRequest javaHttpRequest = javaHttpRequestBuilder.build();
        return javaHttpRequest;
    }

    private static URI getURI(String url, Map<String, String> queries) {
        UriBuilder uriBuilder = UriBuilder.fromUri(url);

        if (queries != null) {
            queries.forEach(uriBuilder::queryParam);
        }

        return uriBuilder.build();
    }

    private static BodyPublisher getRequestBodyPublisher(HttpRequest myHttpRequest) {

        BodyPublisher bodyPublisher = myHttpRequest.body() != null ? BodyPublishers.ofString(myHttpRequest.body())
                                                               : BodyPublishers.noBody();

        return bodyPublisher;
    }
}