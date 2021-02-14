package com.interview.cache;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class InMemoryCache  {
    private final Map<String, String> cacheData = new ConcurrentHashMap<>();
    private final LinkedList<String> linkedList = new LinkedList<>();
    private final int maxSize;
    private static final int DEFAULT_MAX_SIZE = 10;

    public InMemoryCache() {
        this(DEFAULT_MAX_SIZE);
    }

    public InMemoryCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String key, String value) {
        /*
         * If already exists
         */

        if (cacheData.containsKey(key)) {
            updateLinkedList(key);
            cacheData.put(key, value);
            return;
        }

        /*
         * Remove last element if size is more than max size
         */
        if (cacheData.size() >= maxSize) {
            String lastKey = linkedList.removeLast();
            cacheData.remove(lastKey);
        }

        /*
         * Add new element
         */
        updateLinkedList(key);
        cacheData.put(key, value);
    }


    private void updateLinkedList(String key) {
        linkedList.remove(key);
        linkedList.addFirst(key);
    }

    public String get(String key) {
        if (!cacheData.containsKey(key)) {
            return null;
        }

        String value = cacheData.get(key);
        updateLinkedList(key);

        return value;
    }

    public String evict(String key) {
        if (!cacheData.containsKey(key)) {
            return null;
        }

        String value = cacheData.remove(key);
        linkedList.remove(key);

        return value;
    }

    public void printAll() {
        linkedList.forEach((k) -> log.info("{}={}", k, cacheData.get(k)));
        log.info("========= END =========");
    }
}
