package io.shekhar.java8.programs.fizzbuzz;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by shekhargulati on 23/09/15.
 */
public class FizzBuzz_Java8 {

    public Map<Message, List<Integer>> fizzBuzz(int start, int end) {
        if (start < 0 || end < start) {
            throw new IllegalArgumentException(String.format("Invalid start '%s' and end '%s'", start, end));
        }
        return IntStream.rangeClosed(start, end).boxed().collect(groupingBy((Integer number) -> {
            if (number % 3 == 0 && number % 5 == 0) {
                return Message.FIZZBUZZ;
            } else if (number % 3 == 0) {
                return Message.FIZZ;
            } else if (number % 5 == 0) {
                return Message.BUZZ;
            } else {
                return Message.IGNORE;
            }
        }));
    }
}
