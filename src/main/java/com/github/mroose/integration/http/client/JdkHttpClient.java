package com.github.mroose.integration.http.client;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public class JdkHttpClient implements IHttpClient {

    private static JdkHttpClient INSTANCE;

    private JdkHttpClient() {}

    public static synchronized JdkHttpClient getInstance() {
        return INSTANCE == null ? new JdkHttpClient() : INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}