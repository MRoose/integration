package com.github.mroose.integration.http.provider.reactor.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;
import com.github.mroose.integration.http.core.provider.HttpProviderType;

public class ReactorHttpProvider implements HttpProvider {

    private static ReactorHttpProvider INSTANCE;

    private ReactorHttpProvider() {}

    public static synchronized ReactorHttpProvider getInstance() {
        return INSTANCE == null ? new ReactorHttpProvider() : INSTANCE;
    }

    @Override
    public HttpProviderType getType() {
        return HttpProviderType.REACTOR;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}