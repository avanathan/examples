package com.interview.cache;

public interface Cache<K,V> {

    /**
     * Add entry in the cache
     * @param key k
     * @param value v
     */
    void put(K key, V value);

    V get(String key);
    V evict(String key);
}
