package com.github.mroose.integration.http.client;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public class OkHttpHttpClient implements IHttpClient {

    private static OkHttpHttpClient INSTANCE;

    private OkHttpHttpClient() {}

    public static synchronized OkHttpHttpClient getInstance() {
        return INSTANCE == null ? new OkHttpHttpClient() : INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}