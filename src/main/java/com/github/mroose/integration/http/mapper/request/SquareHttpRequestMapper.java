package com.github.mroose.integration.http.mapper.request;

import com.github.mroose.integration.http.domain.HttpMethod;

import okhttp3.*;

import java.util.List;
import java.util.Map;

public class SquareHttpRequestMapper implements HttpRequestMapper {

    @Override
    public Object mapRequest(com.github.mroose.integration.http.domain.HttpRequest httpRequest) {
        return null;
    }

    public Request map(com.github.mroose.integration.http.domain.HttpRequest httpRequest) {
        Request.Builder builder = new Request.Builder()
                .url(httpRequest.getUrl());

        // Map headers from your class to OkHttp Request headers
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            String headerName = entry.getKey();
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                builder.addHeader(headerName, value);
            }
        }

        // Map queries from your class to OkHttp Request queries
        HttpUrl.Builder urlBuilder = HttpUrl.parse(httpRequest.getUrl()).newBuilder();
        for (Map.Entry<String, List<String>> entry : httpRequest.getQueries().entrySet()) {
            String paramName = entry.getKey();
            List<String> paramValues = entry.getValue();
            for (String value : paramValues) {
                urlBuilder.addQueryParameter(paramName, value);
            }
        }
        HttpUrl urlWithQueries = urlBuilder.build();
        builder.url(urlWithQueries);

        // Map method and body from your class to OkHttp Request method and body
        HttpMethod httpMethod = httpRequest.getHttpMethod();
        String body = httpRequest.getBody();
        if (httpMethod == HttpMethod.GET || httpMethod == HttpMethod.HEAD) {
            builder.method(httpMethod.toString(), null);
        } else {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
            builder.method(httpMethod.toString(), requestBody);
        }

        return builder.build();
    }

    public Request mapToOkHttpRequest(com.github.mroose.integration.http.domain.HttpRequest httpRequest) {
        Request.Builder builder = new Request.Builder()
                .url(httpRequest.getUrl());

        // Map headers from your class to OkHttp Request headers
        httpRequest.getHeaders().forEach((headerName, headerValues) ->
                headerValues.forEach(value -> builder.addHeader(headerName, value)));

        // Map queries from your class to OkHttp Request queries
        HttpUrl.Builder urlBuilder = HttpUrl.parse(httpRequest.getUrl()).newBuilder();
        httpRequest.getQueries().forEach((paramName, paramValues) ->
                paramValues.forEach(value -> urlBuilder.addQueryParameter(paramName, value)));
        HttpUrl urlWithQueries = urlBuilder.build();
        builder.url(urlWithQueries);

        // Map method and body from your class to OkHttp Request method and body
        HttpMethod httpMethod = httpRequest.getHttpMethod();
        String body = httpRequest.getBody();
        if (httpMethod == HttpMethod.GET || httpMethod == HttpMethod.HEAD) {
            builder.method(httpMethod.toString(), null);
        } else {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
            builder.method(httpMethod.toString(), requestBody);
        }

        return builder.build();
    }
}