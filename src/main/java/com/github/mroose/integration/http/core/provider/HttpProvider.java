package com.github.mroose.integration.http.core.provider;

import com.github.mroose.integration.http.core.domain.HttpProviderType;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;
import com.github.mroose.integration.http.provider.jdk.provider.JdkHttpProvider;
import com.github.mroose.integration.http.provider.reactor.provider.ReactorHttpProvider;
import com.github.mroose.integration.http.provider.square.provider.SquareHttpProvider;

public interface HttpProvider {

    HttpResponse sendRequest(HttpRequest request);

    static HttpProvider getProvider(HttpProviderType providerType) {
        switch (providerType) {
            case JDK:
                return JdkHttpProvider.getInstance();
            case SQUARE:
                return SquareHttpProvider.getInstance();
            case REACTOR:
                return ReactorHttpProvider.getInstance();
            default:
                throw new IllegalArgumentException("Unsupported HttpProviderType!");
        }
    }
}