package com.github.mroose.integration.http.provider.square.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;

public final class SquareHttpProvider implements HttpProvider {

    private SquareHttpProvider() {}

    private static final class InstanceHolder {
        private static final SquareHttpProvider INSTANCE = new SquareHttpProvider();
    }

    public static SquareHttpProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}