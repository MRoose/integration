package com.github.mroose.integration.http.mapper.response;

import com.github.mroose.integration.http.domain.HttpResponse;

public interface HttpResponseMapper<T> {
    HttpResponse mapResponse(T httpResponse);
}