package com.github.mroose.integration.http.core;

import com.github.mroose.integration.http.core.builder.HttpClientBuilder;
import com.github.mroose.integration.http.core.domain.HttpRequest;
import com.github.mroose.integration.http.core.domain.HttpResponse;
import com.github.mroose.integration.http.core.domain.HttpVersion;
import com.github.mroose.integration.http.core.provider.HttpProvider;
import com.github.mroose.integration.http.core.domain.HttpProviderType;

public class HttpClient {

    private HttpProviderType httpProviderType;
    private HttpVersion httpVersion;

    private HttpProvider httpProvider;

    public static HttpClientBuilder builder() {
        return new HttpClientBuilder();
    }

    public HttpClient(HttpProviderType httpProviderType) {
        this.httpProviderType = httpProviderType;
        this.httpProvider = HttpProvider.getProvider(httpProviderType);
    }

    public HttpResponse sendRequest(HttpRequest httpRequest) {
        return httpProvider.sendRequest(httpRequest);
    }
}