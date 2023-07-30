package com.github.mroose.integration.http.provider.jdk.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;

public final class JdkHttpProvider implements HttpProvider {

    private JdkHttpProvider() {
    }

    private static final class InstanceHolder {
        private static final JdkHttpProvider INSTANCE = new JdkHttpProvider();
    }

    public static JdkHttpProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}