package io.shekhar.java8.programs.anagrams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Two or more words can be composed of the same characters, but in a different order.
 * Using the word list at http://www.puzzlers.org/pub/wordlists/unixdict.txt,
 * find the sets of words that share the same characters and contain the most words in them.
 */
public class Anagram_Java8 {

    /**
     * Group anagram word and its matches
     *
     * @param path
     * @return
     * @throws Exception
     */
    public Map<String, List<String>> anagramGroups(String path) throws Exception {
        Stream<String> lines = Files.lines(Paths.get(path));
        return lines.collect(groupingBy(this::groupingKey));
    }

    public Entry<String, Long> anagramWithMaxElements(String path) throws Exception {
        Stream<String> lines = Files.lines(Paths.get(path));
        Comparator<Entry<String, Long>> comparator = (e1, e2) -> Long.valueOf(e1.getValue() - e2.getValue()).intValue();
        return lines
                .collect(groupingBy(this::groupingKey, counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .sorted(comparator.reversed())
                .findFirst()
                .get();
    }

    public Entry<String, List<String>> anagramWithMaxElements1(String path) throws Exception {
        Stream<String> lines = Files.lines(Paths.get(path));
        Comparator<Entry<String, List<String>>> comparator = (e1, e2) -> e1.getValue().size() - e2.getValue().size();
        return lines
                .collect(groupingBy(this::groupingKey))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .sorted(comparator.reversed())
                .findFirst()
                .get();
    }

    private String groupingKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }


}
