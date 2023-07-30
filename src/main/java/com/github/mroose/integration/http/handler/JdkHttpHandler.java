package com.github.mroose.integration.http.handler;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class JdkHttpHandler implements HttpHandler {

    private final HttpClient httpClient;

    private JdkHttpHandler() {
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
    }

    @Override
    public com.github.mroose.integration.http.domain.HttpResponse sendRequest(com.github.mroose.integration.http.domain.HttpRequest request) {
        return null;
    }

    private static final class InstanceHolder {
        private static final JdkHttpHandler INSTANCE = new JdkHttpHandler();
    }

    public static JdkHttpHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public com.github.mroose.integration.http.domain.HttpResponse sendRequest(HttpRequest request) {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}