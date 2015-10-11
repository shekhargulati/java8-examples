package io.shekhar.java8.programs.fizzbuzz;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FizzBuzzBigInteger {

    public static void main(String[] args) {
        BigInteger one = BigInteger.ONE;
        Stream<BigInteger> numbers = Stream.iterate(one, el -> el.add(one));

        Predicate<BigInteger> divBy3 = number -> number.remainder(BigInteger.valueOf(3)) == BigInteger.ZERO;
        Predicate<BigInteger> divBy5 = number -> number.remainder(BigInteger.valueOf(5)) == BigInteger.ZERO;
        Predicate<BigInteger> divBy3And5 = divBy3.and(divBy5);

        Stream<String> fizzBuzzStream = numbers
                .map(String::valueOf)
                .map(number -> parse(number, divBy3And5, () -> "FizzBuzz"))
                .map(number -> parse(number, divBy3, () -> "Fizz"))
                .map(number -> parse(number, divBy5, () -> "Buzz"));

        fizzBuzzStream.limit(100).forEach(System.out::println);
    }

    private static String parse(String numberStr, Predicate<BigInteger> predicate, Supplier<String> supplier) {
        try {
            BigInteger number = new BigInteger(numberStr);
            if (predicate.test(number)) {
                return supplier.get();
            }
            return numberStr;
        } catch (NumberFormatException e) {
            return numberStr;
        }
    }
}
