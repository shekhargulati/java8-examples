package io.shekhar.trainings.java8.lambdas.internals;

import java.util.function.Consumer;

/**
 * Created by shekhargulati on 11/10/15.
 */
public class LambdaMechanics {
    public static void main(String[] args) {
        doSth("shekhar", name -> System.out.println(name));
    }

    private static <T> void doSth(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
