package com.github.mroose.integration.http.core.mapper;

import com.github.mroose.integration.http.core.domain.HttpResponse;

public interface HttpResponseMapper {
    <T> HttpResponse map(T httpResponse);
}