package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test

    public void testWordCount1() {

        WordCount wordcount = new WordCount();

        String[] words = {"ba", "ba", "black", "sheep"};

        Map<String, Integer> word = new HashMap<>();
        word.put("ba", 2);
        word.put("black", 1);
        word.put("sheep", 1);

        Map<String, Integer> result = wordcount.getCount(words);
        Assert.assertEquals(word, result);

    }
}
