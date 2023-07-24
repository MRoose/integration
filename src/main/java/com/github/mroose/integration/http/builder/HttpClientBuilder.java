package com.github.mroose.integration.http.builder;

import com.github.mroose.integration.http.client.HttpClient;
import com.github.mroose.integration.http.client.IHttpClient;
import com.github.mroose.integration.http.domain.HttpProvider;

public class HttpClientBuilder {

    private HttpProvider httpProvider;

    private HttpClientBuilder httpProvider(HttpProvider httpProvider) {
        this.httpProvider = httpProvider;
        return this;
    }

    public HttpClient build() {
        return new HttpClient(httpProvider);
    }
}