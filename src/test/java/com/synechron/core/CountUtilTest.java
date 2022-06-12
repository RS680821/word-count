package com.synechron.core;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class CountUtilTest {

    @Inject
    InternalCache internalCache;

    @Test
    public void testCountUtil() {
        Assertions.assertTrue(CountUtil.count(internalCache, "wow") == 0);
        Assertions.assertTrue(CountUtil.count(internalCache, "") == 0);
        Assertions.assertTrue(CountUtil.count(internalCache, null) == 0);
    }

    @Test
    public void testAddUtil() {
        CountUtil.add(internalCache, null);
        CountUtil.add(internalCache, new ArrayList<>());
        CountUtil.add(internalCache, Arrays.asList("hi","", "hello"));
        CountUtil.add(internalCache, List.of("bla"));
        CountUtil.add(internalCache, List.of("nla1"));
        Assertions.assertTrue(CountUtil.count(internalCache, "nla1") == 0);
        CountUtil.add(internalCache, List.of("simple"));
        CountUtil.add(internalCache, List.of("bla"));
        Assertions.assertTrue(CountUtil.count(internalCache, "bla") == 2);
        CountUtil.add(internalCache, List.of("âme"));
        Assertions.assertTrue(CountUtil.count(internalCache, "âme") == 1);
        CountUtil.add(internalCache, List.of(" bla")); // shouldn't be added as it is not a word.
    }
}
