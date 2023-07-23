package com.github.mroose.integration.proxy.model;

public class Route {

    public enum Type {
        REST,
        SOAP
    }

    public enum Method {
        GET,
        POST,
        PUT,
        PATCH,
        DELETE
    }

    private String upstream;
    private Type type;
    private Method method;
    private String url;
}