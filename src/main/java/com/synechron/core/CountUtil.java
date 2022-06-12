package com.synechron.core;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public final class CountUtil {

    /**
     * Private Constructor.
     */
    private CountUtil() {
    }

    /**
     * Count Logic.
     *
     * @param internalCache internalCache
     * @param word          word
     * @return int
     */
    public static int count(final InternalCache internalCache, final String word) {
        if (StringUtils.isNotEmpty(word)) {
            return internalCache.getKey(word);
        } else {
            return 0;
        }
    }

    /**
     * Add to Cache.
     *
     * @param internalCache internalCache
     * @param words         words
     */
    public static void add(final InternalCache internalCache, final List<String> words) {
        if (words != null && !words.isEmpty()) {
            for (final String word : words) {
                handleAdd(internalCache, word);
            }
        }
    }

    private static void handleAdd(final InternalCache internalCache, final String word) {
        if (StringUtils.isAlpha(word) && StringUtils.isNotEmpty(word)) {
            final String translatedWord = Translator.translate(word);
            if (internalCache.getKey(translatedWord) != 0) {
                internalCache.increment(translatedWord);
            } else {
                internalCache.init(translatedWord);
            }
        }
    }
}
