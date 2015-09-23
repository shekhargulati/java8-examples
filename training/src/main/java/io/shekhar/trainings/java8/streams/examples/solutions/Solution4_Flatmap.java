package io.shekhar.trainings.java8.streams.examples.solutions;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.stream.Stream;

import static io.shekhar.trainings.java8.utils.DataUtils.lines;

/**
 * Created by shekhargulati on 18/09/15.
 * <p>
 * Word count example
 */
public class Solution4_Flatmap {

    public static void main(String[] args) throws Exception {
        Stream<String> lines = lines();

        lines.flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, word.length()))
                .forEach(System.out::println);

    }

}
