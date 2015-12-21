package io.shekhar.trainings.java8.sec04.examples;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 11/10/15.
 */
public class Example8_InfiniteStreams {

    public static void main(String[] args) {
        Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());
        uuidStream.forEach(System.out::println);
    }
}
