package com.github.mroose.integration.http.provider.jdk.mapper;

import com.github.mroose.integration.http.core.domain.HttpResponse;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseMapper {

    public static HttpResponse map(java.net.http.HttpResponse<String> javaHttpResponse) {

        HttpHeaders httpHeaders = javaHttpResponse.headers();
        Map<String, String> headers = responseHeaderMap(httpHeaders.map());

        HttpResponse myHttpResponse = HttpResponse.builder()
            .statusCode(javaHttpResponse.statusCode())
            .headers(headers)
            .body(javaHttpResponse.body())
            .build();

        return myHttpResponse;
    }

    private static Map<String, String> responseHeaderMap(Map<String, List<String>> inputHeaders) {
        Map<String, String> outputHeaders = new HashMap<>();

        if (inputHeaders == null || inputHeaders.isEmpty()) {
            return outputHeaders;
        }

        inputHeaders.forEach((headerName, headerValues) -> {

            if (headerValues == null || headerValues.isEmpty()) {
                return;
            }

            outputHeaders.put(headerName, String.join("; ", headerValues));
        });

        return outputHeaders;
    }
}