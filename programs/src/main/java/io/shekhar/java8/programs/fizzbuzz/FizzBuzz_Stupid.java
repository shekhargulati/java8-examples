package io.shekhar.java8.programs.fizzbuzz;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by shekhargulati on 21/10/15.
 */
public class FizzBuzz_Stupid {
    public static void main(String[] args) {
        IntStream numbers = IntStream.iterate(1, el -> el + 1);
        IntPredicate divBy3 = number -> number % 3 == 0;
        IntPredicate divBy5 = number -> number % 5 == 0;
        IntPredicate divBy3And5 = divBy3.and(divBy5);

        numbers.limit(20).forEach(number -> {
            if (divBy3And5.test(number)) {
                System.out.println(String.format("%d >> FizzBuzz", number));
            } else if (divBy3.test(number)) {
                System.out.println(String.format("%d >> Fizz", number));
            } else if (divBy5.test(number)) {
                System.out.println(String.format("%d >> Buzz", number));
            } else {
                System.out.println(number);
            }

        });
    }
}
