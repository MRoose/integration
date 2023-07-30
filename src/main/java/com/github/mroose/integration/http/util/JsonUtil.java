package com.github.mroose.integration.http.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonUtil {

    private final JsonMapper jsonMapper;

    private JsonUtil() {
        jsonMapper = new JsonMapper();
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private static final class InstanceHolder {
        private static final JsonUtil INSTANCE = new JsonUtil();
    }

    public static JsonUtil getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public String serialize(Object content) {
        try {
            return jsonMapper.writeValueAsString(content);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T deserialize(String content, Class<T> valueType) {
        try {
            return jsonMapper.readValue(content, valueType);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T deserialize(String content, TypeReference<T> valueTypeRef) {
        try {
            return jsonMapper.readValue(content, valueTypeRef);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T jsonPath(String content, String jsonPath) {
        try {
            return JsonPath.parse(content).read(jsonPath);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T jsonPath(Object content, String jsonPath) {
        try {
            return JsonPath.parse(content).read(jsonPath);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T jsonPath(String content, List<String> jsonPaths) {

        T variable = null;

        for (String jsonPath : jsonPaths) {
            variable = jsonPath(content, jsonPath);

            if (variable != null) {
                break;
            }
        }

        return variable;
    }

    public <T> T jsonPath(Object content, List<String> jsonPaths) {
        T variable = null;

        for (String jsonPath : jsonPaths) {
            variable = jsonPath(content, jsonPath);

            if (variable != null) {
                break;
            }
        }

        return variable;
    }

    public <T> T jsonPath(String content, String jsonPath, Class<T> tClass) {
        try {
            return JsonPath.parse(content).read(jsonPath, tClass);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T jsonPath(Object content, String jsonPath, Class<T> tClass) {
        try {
            return JsonPath.parse(content).read(jsonPath, tClass);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T jsonPath(String content, List<String> jsonPaths, Class<T> tClass) {
        T variable = null;

        for (String jsonPath : jsonPaths) {
            variable = jsonPath(content, jsonPath, tClass);

            if (variable != null) {
                break;
            }
        }

        return variable;
    }

    public <T> T jsonPath(Object content, List<String> jsonPaths, Class<T> tClass) {
        T variable = null;

        for (String jsonPath : jsonPaths) {
            variable = jsonPath(content, jsonPath, tClass);

            if (variable != null) {
                break;
            }
        }

        return variable;
    }
}