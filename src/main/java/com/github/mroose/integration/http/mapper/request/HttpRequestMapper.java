package com.github.mroose.integration.http.mapper.request;

import com.github.mroose.integration.http.domain.HttpRequest;

public interface HttpRequestMapper<T> {
    T mapRequest(HttpRequest httpRequest);
}