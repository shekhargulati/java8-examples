package io.shekhar.java8.programs.fizzbuzz;

import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 11/10/15.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        IntStream numbers = IntStream.iterate(1, el -> el + 1);

        IntPredicate divBy3 = number -> number % 3 == 0;
        IntPredicate divBy5 = number -> number % 5 == 0;
        IntPredicate divBy3And5 = divBy3.and(divBy5);

        Stream<String> fizzBuzzStream = numbers
                .mapToObj(String::valueOf)
                .map(number -> parse(number, divBy3And5, () -> "FizzBuzz"))
                .map(number -> parse(number, divBy3, () -> "Fizz"))
                .map(number -> parse(number, divBy5, () -> "Buzz"));

        fizzBuzzStream.forEach(System.out::println);
    }

    private static String parse(String numberStr, IntPredicate predicate, Supplier<String> supplier) {
        try {
            int number = Integer.parseInt(numberStr);
            if (predicate.test(number)) {
                return supplier.get();
            }
            return numberStr;
        } catch (NumberFormatException e) {
            return numberStr;
        }
    }
}
