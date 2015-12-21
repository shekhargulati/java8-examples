package io.shekhar.trainings.java8.sec03.examples;

import java.util.function.IntConsumer;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example4_EffectiveFinal {

    public static void main(String[] args) {
        int number = 0;
//        number++;
        IntConsumer consumer = i -> System.out.println(i + number);
        consumer.accept(5);
    }

}


