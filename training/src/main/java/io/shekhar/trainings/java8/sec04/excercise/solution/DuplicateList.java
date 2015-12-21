package io.shekhar.trainings.java8.sec04.excercise.solution;

import java.util.Arrays;
import java.util.List;

/**
 * Duplicate all the elements in a List
 */
public class DuplicateList {

    public static <T> void duplicate(List<T> list) {
    }

    public static <T> void duplicate(List<T> list, int n) {
    }


    public static void main(String[] args) {
        duplicate(Arrays.asList("a", "b", "c", "d", "e"));
        duplicate(Arrays.asList("a", "b", "c", "d", "e"), 3);
    }

}
