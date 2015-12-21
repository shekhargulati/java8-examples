package io.shekhar.trainings.java8.sec04.excercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Duplicate all the elements in a List
 */
public class DuplicateList {

    public static <T> void duplicate(List<T> list) {
        list.stream().flatMap(e -> Stream.of(e, e)).forEach(System.out::println);
    }

    public static <T> void duplicate(List<T> list, int n) {
        list.stream().flatMap(e -> Stream.generate(() -> e).limit(n)).forEach(System.out::println);
    }


    public static void main(String[] args) {
        duplicate(Arrays.asList("a", "b", "c", "d", "e"));
        duplicate(Arrays.asList("a", "b", "c", "d", "e"), 3);
    }

}
