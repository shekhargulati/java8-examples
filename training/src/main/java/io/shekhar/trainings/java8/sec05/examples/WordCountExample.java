package io.shekhar.trainings.java8.sec05.examples;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static io.shekhar.trainings.java8.utils.DataUtils.lines;
import static java.util.stream.Collectors.*;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class WordCountExample {

    public static void main(String[] args) throws IOException {
        Map<String, Long> wordCount = lines()
                .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .collect(groupingBy(SimpleEntry::getKey, counting()));

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

        // find top 20 words
        Comparator<Map.Entry<String, Long>> comparator = (e1, e2) -> Long.valueOf(e1.getValue() - e2.getValue()).intValue();
        List<Map.Entry<String, Long>> top20Words = wordCount.entrySet().stream().sorted(comparator.reversed()).limit(20).collect(toList());
        top20Words.forEach(System.out::println);

    }
}
