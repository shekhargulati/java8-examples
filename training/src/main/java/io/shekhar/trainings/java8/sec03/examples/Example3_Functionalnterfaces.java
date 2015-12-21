package io.shekhar.trainings.java8.sec03.examples;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example3_Functionalnterfaces {

    public static void main(String[] args) {

        Predicate<String> nameStartWithS = name -> name.startsWith("s");

        Consumer<String> sendEmail = message -> System.out.println("Sending email >> " + message);

        Function<String, Integer> stringToLength = name -> name.length();

        Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();

    }
}
