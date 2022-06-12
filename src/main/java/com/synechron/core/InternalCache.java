package com.synechron.core;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InternalCache {

    private final Map<String, Integer> map = new ConcurrentHashMap();

    /**
     * Initialise Map.
     *
     * @param key key
     */
    public void init(final String key) {
        map.put(buildKey(key), 1);
    }

    /**
     * Increment map.
     *
     * @param key key
     */
    public void increment(final String key) {
        final Integer integer = map.get(buildKey(key));
        map.put(buildKey(key), (integer + 1));
    }


    /**
     * Get Key count.
     *
     * @param key key
     * @return Integer
     */
    public Integer getKey(final String key) {
        return (map.get(buildKey(key)) != null ? map.get(buildKey(key)) : 0);
    }

    private String buildKey(final String key) {
        return key.toLowerCase();
    }
}
