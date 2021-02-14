package com.interview;

import com.interview.cache.InMemoryCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@Slf4j
public class CacheTest {

    @Test
    void cacheTest() {
        InMemoryCache inMemoryCache = new InMemoryCache(4);

        inMemoryCache.put("one", "ONE");
        inMemoryCache.printAll();
        inMemoryCache.put("two", "TWO");
        inMemoryCache.printAll();
        inMemoryCache.put("three", "THREE");
        inMemoryCache.get("one");
        inMemoryCache.printAll();
        inMemoryCache.put("four", "FOUR");
        inMemoryCache.printAll();
        inMemoryCache.put("five", "FIVE");
        inMemoryCache.printAll();
        inMemoryCache.put("six", "SIX");
        inMemoryCache.printAll();

        log.info("one={}", inMemoryCache.get("one"));
        log.info("two={}", inMemoryCache.get("two"));


    }
}
