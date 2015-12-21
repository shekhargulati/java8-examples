package io.shekhar.trainings.java8.sec04.examples;

import java.util.stream.Stream;

import static io.shekhar.trainings.java8.utils.DataUtils.lines;

/**
 * Created by shekhargulati on 18/09/15.
 * <p>
 * Word count example
 */
public class Example4_Flatmap {

    public static void main(String[] args) throws Exception {
        Stream<String> lines = lines();
        // Return word and their length >> word.replaceAll("[^a-zA-Z]", "") >> SimpleEntry

    }

}
