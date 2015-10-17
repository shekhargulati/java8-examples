package io.shekhar.java8.programs.sliding;

import java.util.Arrays;

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
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(input.split(""))
                .map(ch -> sb.append(ch).toString())
                .forEach(System.out::println);
    }
}
