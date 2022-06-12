package com.synechron.core;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class InternalCacheTest {

    @Inject
    InternalCache internalCache;

    @Test
    public void testInternalCache() {
        internalCache.init("BLA");
        Assertions.assertTrue(internalCache.getKey("bla").equals(1));
        internalCache.increment("BLA");
        Assertions.assertTrue(internalCache.getKey("bla").equals(2));
    }
}
