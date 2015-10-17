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
        Arrays.stream(input.split(""))
                .map(ch -> input.substring(0, input.indexOf(ch) + 1))
                .forEach(System.out::println);
    }
}
