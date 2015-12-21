package io.shekhar.trainings.java8.sec04.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

/**
 * Created by shekhargulati on 18/09/15.
 * Filtering and related examples
 */
public class Example2_FilterStreams {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        System.out.println("filtering all reading tasks>> \n");


        System.out.println();
        // show Predicate composition >> reading and created after
        System.out.println("show Predicate composition >> \n");

        System.out.println();
        // finding distinct tasks
        System.out.println("finding distinct tasks >> \n");
        tasks.add(new Task("Read Java 8 in action", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading"));

        System.out.println();

        // limit and skip
        System.out.println("limit and skip usage >> \n");

        System.out.println();
        // counting all elements
        System.out.println("counting elements >> \n");

        System.out.println();
    }
}
