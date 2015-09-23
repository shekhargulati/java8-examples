package io.shekhar.java8.programs.accumulator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * a function that takes a single (numeric) argument and which returns another function that is an accumulator.
 * The returned accumulator function in turn also takes a single numeric argument, and returns the sum of all
 * the numeric values passed in so far to that accumulator (including the initial value passed when the
 * accumulator was created).
 */
public class AccumulatorFactory_Java8 {

    public static IntFunction<Integer> accumulator(int n) {
        List<Integer> numbers = new ArrayList<>();
        return (i) -> {
            numbers.add(i);
            return n + numbers.stream().mapToInt(number -> number).sum();
        };
    }

    public static void main(String[] args) {
        IntFunction<Integer> x = accumulator(1);
        x.apply(5);
        IntFunction<Integer> y = accumulator(4);
        System.out.println(x.apply(5));
        y.apply(3);
        System.out.println(y.apply(5));

    }
}
