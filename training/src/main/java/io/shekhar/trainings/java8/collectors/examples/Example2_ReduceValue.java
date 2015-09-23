package io.shekhar.trainings.java8.collectors.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example2_ReduceValue {

    private Task task = new Task("Read Java 8 in action", TaskType.READING, LocalDate.of(2015, Month.SEPTEMBER, 20)).addTag("java").addTag("java8").addTag("books");

    public List<String> allTitles(List<Task> tasks) {
        return Collections.emptyList();
    }

    public Set<String> uniqueTitle(List<Task> tasks) {
        return Collections.emptySet();
    }

    public Map<String, Task> collectToMap(List<Task> tasks) {
        return Collections.emptyMap();
    }

    /*
    Example of maxBy
     */
    public Task taskWithLongestTitle(List<Task> tasks) {
        return null;
    }

    /*
        example of summingInt
     */
    public int totalTagCount(List<Task> tasks) {
        return 0;
    }

    /*
        summarizingInt
     */
    public IntSummaryStatistics summarizeTitleLength(List<Task> tasks) {
        return null;
    }

    /*
        joining
     */
    public String titleSummary(List<Task> tasks) {
        return null;
    }

}
