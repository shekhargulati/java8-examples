package io.shekhar.trainings.java8.streams.examples.solutions;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;

import static io.shekhar.trainings.java8.utils.DataUtils.negativeWords;

/**
 * Created by shekhargulati on 18/09/15.
 * This is an example of Map
 */
public class Solution3_MapStreams {

    public static void main(String[] args) throws Exception {
        Stream<String> words = negativeWords();
        words.map(word -> new SimpleEntry<>(word, word.length())).forEach(System.out::println);
    }
}
