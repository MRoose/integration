package com.github.mroose.integration.http.mapper.response;

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
    public com.github.mroose.integration.http.domain.HttpResponse mapResponse(HttpResponse<String> httpResponse) {
        return com.github.mroose.integration.http.domain.HttpResponse
                .builder()
                .statusCode(httpResponse.statusCode())
                .headers(httpResponse.headers().map())
                .body(httpResponse.body())
                .build();
    }
}