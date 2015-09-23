package io.shekhar.java8.programs.fizzbuzz;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Write a program that prints the integers from 1 to 100.
 * But for multiples of three print "Fizz" instead of the number, and for the multiples of five print "Buzz".
 * For numbers which are multiples of both three and five print "FizzBuzz".
 * FizzBuzz was presented as the lowest level of comprehension required to illustrate adequacy.
 */
public class FizzBuzz_Java8_V2 {

    public Map<Message, List<Integer>> fizzBuzz(int start, int end) {
        return fizzBuzz(start, end, number -> number % 3 == 0, number -> number % 5 == 0);
    }

    public Map<Message, List<Integer>> fizzBuzz(int start, int end, Predicate<Integer> p1, Predicate<Integer> p2) {
        if (start < 0 || end < start) {
            throw new IllegalArgumentException(String.format("Invalid start '%s' and end '%s'", start, end));
        }
        return IntStream.rangeClosed(start, end).boxed().collect(groupingBy(number -> {
            if (p1.and(p2).test(number)) {
                return Message.FIZZBUZZ;
            } else if (p1.test(number)) {
                return Message.FIZZ;
            } else if (p2.test(number)) {
                return Message.BUZZ;
            } else {
                return Message.IGNORE;
            }
        }));
    }
}
