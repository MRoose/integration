package com.github.mroose.integration.http.client;

import com.github.mroose.integration.http.builder.HttpClientBuilder;
import com.github.mroose.integration.http.domain.HttpProvider;
import com.github.mroose.integration.http.domain.HttpRequest;
import com.github.mroose.integration.http.domain.HttpResponse;
import com.github.mroose.integration.http.util.JsonUtil;

public class HttpClient {

    private HttpProvider httpProvider;
    private IHttpClient httpClient;
    private JsonUtil jsonUtil;

    public static HttpClientBuilder builder() {
        return new HttpClientBuilder();
    }

    public HttpClient(HttpProvider httpProvider) {
        this.httpProvider = httpProvider;
        switch (httpProvider) {
            case JDK:
                this.httpClient = JdkHttpClient.getInstance();
                break;
            case SQUARE:
                this.httpClient = OkHttpHttpClient.getInstance();
                break;
            case REACTOR_NETTY:
                this.httpClient = ReactorNettyHttpClient.getInstance();
                break;
            default:
                throw new IllegalArgumentException("Unsupported HttpProvider");
        }
        this.jsonUtil = JsonUtil.getInstance();
    }

    public HttpResponse sendRequest(HttpRequest httpRequest) {
        return httpClient.sendRequest(httpRequest);
    }

    public <T> T sendRequest(HttpRequest httpRequest, Class<T> valueType) {
        var response = httpClient.sendRequest(httpRequest);

        if (response.getHeaders().containsKey("Content-Type")
                && response.getHeaders().get("Content-Type").stream().anyMatch(h -> h.toLowerCase().contains("json"))) {
            return jsonUtil.deserialize(response.getBody(), valueType);
        }

        if (response.getHeaders().containsKey("Content-Type")
                && response.getHeaders().get("Content-Type").stream().anyMatch(h -> h.toLowerCase().contains("xml"))) {
            //TODO
            return null;
        }

        return null;
    }
}