package com.github.mroose.integration.http.mapper;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public class HttpMapper {

    public static java.net.http.HttpRequest requestMapper(HttpRequest myHttpRequest) {
        return HttpRequestMapper.map(myHttpRequest);
    }

    public static HttpResponse responseMapper(java.net.http.HttpResponse javaHttpResponse) {
        return HttpResponseMapper.map(javaHttpResponse);
    }
}