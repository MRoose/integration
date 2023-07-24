package com.github.mroose.integration.http.client;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public class ReactorNettyHttpClient implements IHttpClient {

    private static ReactorNettyHttpClient INSTANCE;

    private ReactorNettyHttpClient() {}

    public static synchronized ReactorNettyHttpClient getInstance() {
        return INSTANCE == null ? new ReactorNettyHttpClient() : INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}