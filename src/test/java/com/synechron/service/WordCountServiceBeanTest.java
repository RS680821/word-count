package com.synechron.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class WordCountServiceBeanTest {

    @Inject
    WordCountService wordCountService;

    @Test
    public void testService() {
        Assertions.assertTrue(wordCountService.count("rich") == 0);
    }
}
