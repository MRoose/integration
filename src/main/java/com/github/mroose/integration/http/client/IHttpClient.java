package com.github.mroose.integration.http.client;

import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;

public interface IHttpClient {

    HttpResponse sendRequest(HttpRequest request);
}