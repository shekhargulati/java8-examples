package io.shekhar.trainings.java8.sec03.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example1_Lambda {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");

        // sort alphabetically >> Java 7 way of sorting names

        System.out.println("names sorted alphabetically  >>");
        System.out.println(names);
        System.out.println();

        // using anonymous classes >> Comparator

        System.out.println("names sorted by length  >>");
        System.out.println(names);
        System.out.println();

        /**
         * Using lambda
         * Things to show >>
         * 1. return statement
         * 2. Without return statement
         * 3. Multiple lines
         * 4. Type inference
         */


        System.out.println("names sorted by length(reversed)  >>");
        System.out.println(names);
        System.out.println();
    }


}
