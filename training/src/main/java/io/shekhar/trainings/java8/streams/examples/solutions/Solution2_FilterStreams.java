package io.shekhar.trainings.java8.streams.examples.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by shekhargulati on 18/09/15.
 * Filtering and related examples
 */
public class Solution2_FilterStreams {

    public static void main(String[] args) {
        Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
        Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
        Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");
        Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.BLOGGING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
        Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        System.out.println("filtering items >> \n");
        List<Task> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted((t1, t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()))
                .collect(toList());

        readingTasks.forEach(System.out::println);
        System.out.println();
        // show Predicate composition
        System.out.println("show Predicate composition >> \n");
        Predicate<Task> isReadingTask = task -> task.getType() == TaskType.READING;
        Predicate<Task> isCreatedAfter = task -> task.getCreatedOn().isAfter(LocalDate.of(2015, Month.JULY, 4));
        Predicate<Task> isReadingTaskAndCreatedAfter = isReadingTask.and(isCreatedAfter);
        readingTasks = tasks.stream()
                .filter(isReadingTaskAndCreatedAfter)
                .sorted((t1, t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()))
                .collect(toList());

        readingTasks.forEach(System.out::println);
        System.out.println();
        // finding distinct tasks
        System.out.println("finding distinct tasks >> \n");
        tasks.add(new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading"));
        tasks.stream().distinct().collect(toList()).forEach(System.out::println);

        System.out.println();

        // limit and skip
        System.out.println("limit and skip usage >> \n");
        tasks.stream().skip(2).limit(2).forEach(System.out::println);

        System.out.println();
        // counting all elements
        System.out.println("counting elements >> \n");
        System.out.println(tasks.stream().count());

        System.out.println();
    }
}
