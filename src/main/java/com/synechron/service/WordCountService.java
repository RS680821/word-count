package com.synechron.service;

import java.util.List;

public interface WordCountService {

    /**
     * Add words to our map.
     * @param list list
     */
    void add(final List<String> list);

    /**
     * Return a count based on how many times a given word has been added.
     * @param word word
     * @return int
     */
    int count(final String word);
}
