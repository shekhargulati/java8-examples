package io.shekhar.java8.programs.anagrams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 23/09/15.
 */
public class Anagram_Java8 {

    public Map<String, List<String>> anagramGroups(String path) throws Exception {
        Stream<String> lines = Files.lines(Paths.get(path));
        return lines.collect(Collectors.groupingBy((String word) -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }));
    }
}
