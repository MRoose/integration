package com.github.mroose.integration.http.provider.jdk.mapper;

import com.github.mroose.integration.http.core.mapper.HttpResponseMapper;

import java.net.http.HttpResponse;

public class JdkHttpResponseMapper implements HttpResponseMapper<HttpResponse<String>> {

    private JdkHttpResponseMapper() {
    }

    private static final class InstanceHolder {
        private static final JdkHttpResponseMapper INSTANCE = new JdkHttpResponseMapper();
    }

    public static JdkHttpResponseMapper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public com.github.mroose.integration.http.core.domain.HttpResponse mapResponse(HttpResponse<String> httpResponse) {
        return com.github.mroose.integration.http.core.domain.HttpResponse
                .builder()
                .statusCode(httpResponse.statusCode())
                .headers(httpResponse.headers().map())
                .body(httpResponse.body())
                .build();
    }
}