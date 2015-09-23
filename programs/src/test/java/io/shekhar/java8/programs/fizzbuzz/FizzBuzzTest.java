package io.shekhar.java8.programs.fizzbuzz;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * Write a program that prints the integers from 1 to 100.
 * But for multiples of three print "Fizz" instead of the number, and for the multiples of five print "Buzz".
 * For numbers which are multiples of both three and five print "FizzBuzz".
 * FizzBuzz was presented as the lowest level of comprehension required to illustrate adequacy.
 */
public class FizzBuzzTest {

    private final FizzBuzz_Java8 program = new FizzBuzz_Java8();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void givenRangeFrom1To15_WhenICallFizzBuzz_Return4Fizz2BuzzAnd1FizzBuzz() throws Exception {
        Map<Message, List<Integer>> result = program.fizzBuzz(1, 15);
        assertThat(result.get(Message.FIZZ), contains(3, 6, 9, 12));
        assertThat(result.get(Message.BUZZ), contains(5, 10));
        assertThat(result.get(Message.FIZZBUZZ), contains(15));
    }

    @Test
    public void givenRangeFrom1To100_WhenICallFizzBuzz_ReturnFizzBuzzFor15_30_45_60_75_90() throws Exception {
        Map<Message, List<Integer>> result = program.fizzBuzz(1, 100);
        assertThat(result.get(Message.FIZZBUZZ), contains(15, 30, 45, 60, 75, 90));
    }

    @Test
    public void throwExceptionIfRangeIsInvalid() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        program.fizzBuzz(1, -100);
    }
}