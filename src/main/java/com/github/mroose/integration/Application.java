package com.github.mroose.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Application {

    public static String[] convertMapToStringArray(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .flatMap(entry -> Stream.concat(Stream.of(entry.getKey()), entry.getValue().stream()))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, List<String>> map = new HashMap<>();
        map.put("key1", List.of("value1", "value2"));
        map.put("key2", List.of("value1"));

        String[] resultArray = convertMapToStringArray(map);

        System.out.println(resultArray);
    }
}