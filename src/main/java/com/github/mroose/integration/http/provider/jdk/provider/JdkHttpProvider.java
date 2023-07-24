package com.github.mroose.integration.http.provider.jdk.provider;

import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;
import com.github.mroose.integration.http.core.provider.HttpProviderType;

public class JdkHttpProvider implements HttpProvider {

    private static JdkHttpProvider INSTANCE;

    private JdkHttpProvider() {}

    public static synchronized JdkHttpProvider getInstance() {
        return INSTANCE == null ? new JdkHttpProvider() : INSTANCE;
    }

    @Override
    public HttpProviderType getType() {
        return HttpProviderType.JDK;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) {
        return null;
    }
}