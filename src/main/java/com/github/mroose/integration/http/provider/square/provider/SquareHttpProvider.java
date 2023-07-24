package com.github.mroose.integration.http.provider.square.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;
import com.github.mroose.integration.http.core.provider.HttpProviderType;

public class SquareHttpProvider implements HttpProvider {

    private static SquareHttpProvider INSTANCE;

    private SquareHttpProvider() {}

    public static synchronized SquareHttpProvider getInstance() {
        return INSTANCE == null ? new SquareHttpProvider() : INSTANCE;
    }

    @Override
    public HttpProviderType getType() {
        return HttpProviderType.SQUARE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}