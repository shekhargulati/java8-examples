package io.shekhar.java8.programs.sliding;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.IntStream;

/**
 * Given a String "abcdef" the program should print
 * a
 * ab
 * abc
 * abcd
 * abcde
 * abcdef
 */
public class Sliding {

    public static void main(String[] args) {
        final String input = "abcdef";
        IntStream.range(0, input.length())
                .mapToObj(index -> new SimpleEntry<>(String.valueOf(input.charAt(index)), index))
                .map(entry -> input.substring(0, entry.getValue() + 1))
                .forEach(System.out::println);
    }
}
