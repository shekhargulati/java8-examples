package io.shekhar.java8.programs.fizzbuzz;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 11/10/15.
 */
public class Fizzbuzz_Optional {

    public static void main(String[] args) {
        BigInteger one = BigInteger.ONE;

        Predicate<BigInteger> divBy3 = number -> Objects.equals(number.remainder(BigInteger.valueOf(3)), BigInteger.ZERO);
        Predicate<BigInteger> divBy5 = number -> Objects.equals(number.remainder(BigInteger.valueOf(5)), BigInteger.ZERO);
        Predicate<BigInteger> divBy3And5 = divBy3.and(divBy5);

        Stream<BigInteger> numbers = Stream.iterate(one, el -> el.add(one));

        Stream<String> fizzBuzzStream = numbers
                .map(FizzBuzzMatcher.matching(divBy3And5, () -> "FizzBuzz")
                        .otherwise(FizzBuzzMatcher.matching(divBy3, () -> "Fizz")
                                .otherwise(FizzBuzzMatcher.matching(divBy5, () -> "Buzz")
                                        .otherwise(BigInteger::toString))));

        fizzBuzzStream.limit(100).forEach(System.out::println);
    }
}

interface FizzBuzzMatcher extends Function<BigInteger, Optional<String>> {

    static FizzBuzzMatcher matching(Predicate<BigInteger> matcher, Supplier<String> resultMsgSupplier) {
        return number -> matcher.test(number) ? Optional.of(resultMsgSupplier.get()) : Optional.empty();
    }

    default Function<BigInteger, String> otherwise(Function<BigInteger, String> next) {
        return number -> apply(number).orElseGet(() -> next.apply(number));
    }
}