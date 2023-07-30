package com.github.mroose.integration.http.handler;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public interface HttpHandler {

    HttpResponse sendRequest(HttpRequest request);
}