package io.shekhar.trainings.java8.streams.examples;

import static io.shekhar.trainings.java8.utils.DataUtils.negativeWords;

/**
 * Created by shekhargulati on 19/09/15.
 * <p>
 * Finding and matching
 */
public class Example5_FindOperations {

    public static void main(String[] args) {
        // is there any negative word whose length is greater than 5
        System.out.println(negativeWords().anyMatch(word -> word.length() > 5));

        // does all the negative words have length greater than 3
        System.out.println(negativeWords().allMatch(word -> word.length() > 2));

        negativeWords().filter(word -> word.length() < 3).forEach(System.out::println);

        // none of the negative word start with $
        System.out.println(negativeWords().noneMatch(word -> word.startsWith("$")));

        // find any negative word starting with `z`
        System.out.println(negativeWords().filter(word -> word.startsWith("z")).findAny());


    }
}
