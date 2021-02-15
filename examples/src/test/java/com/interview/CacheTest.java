package com.interview;

import com.interview.cache.LRUCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@Slf4j
public class CacheTest {

    @Test
    void cacheTest() {
        LRUCache LRUCache = new LRUCache(4);

        LRUCache.put("one", "ONE");
        LRUCache.printAll();
        LRUCache.put("two", "TWO");
        LRUCache.printAll();
        LRUCache.put("three", "THREE");
        LRUCache.get("one");
        LRUCache.printAll();
        LRUCache.put("four", "FOUR");
        LRUCache.printAll();
        LRUCache.put("five", "FIVE");
        LRUCache.printAll();
        LRUCache.put("six", "SIX");
        LRUCache.printAll();

        log.info("one={}", LRUCache.get("one"));
        log.info("two={}", LRUCache.get("two"));


    }
}
