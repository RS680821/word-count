package com.synechron.service;

import com.synechron.core.CountUtil;
import com.synechron.core.InternalCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class WordCountServiceBean implements WordCountService {

    @Inject
    InternalCache internalCache;

    /**
     * Add words to our map.
     *
     * @param list list
     */
    @Override
    public void add(final List<String> list) {
        CountUtil.add(internalCache, list);
    }

    /**
     * Return a count based on how many times a given word has been added.
     *
     * @param word word
     * @return int
     */
    @Override
    public int count(final String word) {
        return CountUtil.count(internalCache, word);
    }
}
