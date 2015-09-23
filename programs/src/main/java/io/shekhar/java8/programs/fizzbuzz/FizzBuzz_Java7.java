package io.shekhar.java8.programs.fizzbuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a program that prints the integers from 1 to 100.
 * But for multiples of three print "Fizz" instead of the number, and for the multiples of five print "Buzz".
 * For numbers which are multiples of both three and five print "FizzBuzz".
 * FizzBuzz was presented as the lowest level of comprehension required to illustrate adequacy.
 */
public class FizzBuzz_Java7 {

    public Map<Message, List<Integer>> fizzBuzz(final int start, final int end) {
        if (start < 0 || end < start) {
            throw new IllegalArgumentException(String.format("Invalid start '%s' and end '%s'", start, end));
        }
        Map<Message, List<Integer>> result = new HashMap<>();

        List<Integer> fizzNumbers = new ArrayList<>();
        List<Integer> fizzbuzzNumbers = new ArrayList<>();
        List<Integer> buzzNumbers = new ArrayList<>();

        for (int number = start; number <= end; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                fizzbuzzNumbers.add(number);
            } else if (number % 3 == 0) {
                fizzNumbers.add(number);
            } else if (number % 5 == 0) {
                buzzNumbers.add(number);
            }
        }
        result.put(Message.FIZZ, fizzNumbers);
        result.put(Message.BUZZ, buzzNumbers);
        result.put(Message.FIZZBUZZ, fizzbuzzNumbers);
        return result;
    }
}
