package com.github.mroose.integration.http.core.builder;

import com.github.mroose.integration.http.core.HttpClient;
import com.github.mroose.integration.http.core.domain.HttpProviderType;

public class HttpClientBuilder {

    private HttpProviderType httpProviderType;

    private HttpClientBuilder httpProvider(HttpProviderType httpProviderType) {
        this.httpProviderType = httpProviderType;
        return this;
    }

    public HttpClient build() {
        return new HttpClient(httpProviderType);
    }
}