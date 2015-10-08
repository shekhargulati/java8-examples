package io.shekhar.java8.programs.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class WordCount_v2 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("programs", "src", "main", "resources", "book.txt");
        System.out.println(path.toAbsolutePath());
        Map<String, Long> wordCount = Files.lines(path)
                .parallel()
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
