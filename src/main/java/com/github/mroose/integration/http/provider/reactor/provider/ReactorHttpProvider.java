package com.github.mroose.integration.http.provider.reactor.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;

public final class ReactorHttpProvider implements HttpProvider {

    private ReactorHttpProvider() {}

    private static final class InstanceHolder {
        private static final ReactorHttpProvider INSTANCE = new ReactorHttpProvider();
    }

    public static ReactorHttpProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}