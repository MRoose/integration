package com.github.mroose.integration.http.core.mapper;

import com.github.mroose.integration.http.core.domain.HttpRequest;

public interface HttpRequestMapper {
    <T> T map(HttpRequest httpRequest);
}