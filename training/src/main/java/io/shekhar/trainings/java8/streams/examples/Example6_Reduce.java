package io.shekhar.trainings.java8.streams.examples;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.shekhar.trainings.java8.utils.DataUtils.lines;
import static io.shekhar.trainings.java8.utils.DataUtils.range;

/**
 * Created by shekhargulati on 18/09/15.
 * Reduce examples
 */
public class Example6_Reduce {

    public static void main(String[] args) throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumImperative = 0;
        for (int number : numbers) {
            sumImperative += number;
        }
        System.out.printf("Sum of 1-10 using imperative approach >> %d", sumImperative);
        System.out.println();

        // canonical example sum and product of numbers
        int sum = range(1, 10).reduce(0, (acc, element) -> acc + element);
        System.out.printf("Sum of 1-10 is >> %d", sum);
        System.out.println();

        int product = range(1, 10).reduce(1, (acc, element) -> acc * element);
        System.out.printf("Product of 1-10 is >> %d", product);
        System.out.println();

        // max of numbers
        System.out.println(range(1, 100).reduce(Integer::max).getAsInt());

        // Map Reduce word count example
        Map<String, Integer> wordCount = lines().flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .reduce(new LinkedHashMap<>(), (acc, entry) -> {
                    acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
                    return acc;
                }, (m1, m2) -> m1);

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

        //find the longest word along with its length
        SimpleEntry<String, Integer> max = lines().flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, word.length()))
                .max((w1, w2) -> w1.getValue() - w2.getValue()).get();

        System.out.println(max);
    }

}
