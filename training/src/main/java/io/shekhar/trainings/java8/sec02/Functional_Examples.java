package io.shekhar.trainings.java8.sec02;

import java.util.Arrays;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Functional_Examples {

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static int sum(int... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }
}
