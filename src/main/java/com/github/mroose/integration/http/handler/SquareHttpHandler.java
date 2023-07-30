package com.github.mroose.integration.http.handler;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public final class SquareHttpHandler implements HttpHandler {

    private SquareHttpHandler() {}

    private static final class InstanceHolder {
        private static final SquareHttpHandler INSTANCE = new SquareHttpHandler();
    }

    public static SquareHttpHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}