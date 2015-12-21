package io.shekhar.trainings.java8.sec03.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example5_MethodReferences {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");

        // transform name to length

//        System.out.println(namesLength);

        // transform name to uppercase

        //System.out.println(upperCaseNames);

        // Sorting names by their length using comparingInt

        System.out.println(names);
    }

    private static <T, R> List<R> transform(List<T> list, Function<T, R> fx) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(fx.apply(element));
        }
        return result;
    }
}
