package io.shekhar.trainings.java8.sec04.examples;

import io.shekhar.trainings.java8.domain.Task;

import java.util.List;
import java.util.stream.Stream;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;
import static io.shekhar.trainings.java8.utils.DataUtils.negativeWords;

/**
 * Created by shekhargulati on 18/09/15.
 * This is an example of a map operation
 */
public class Example3_MapStreams {

    public static void main(String[] args) throws Exception {
        List<Task> tasks = getTasks();
        // filter all reading tasks and transform task to title

        Stream<String> words = negativeWords();
        // transform to a stream of SimpleEntry of word and its length
    }
}
