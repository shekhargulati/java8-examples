package io.shekhar.trainings.java8.collectors.examples.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Solution2_ReduceValue {

    private Task task = new Task("Read Java 8 in action", TaskType.READING, LocalDate.of(2015, Month.SEPTEMBER, 20)).addTag("java").addTag("java8").addTag("books");

    public List<String> allTitles(List<Task> tasks) {
        return Collections.emptyList();
    }

    public Set<String> uniqueTitle(List<Task> tasks) {
        tasks.add(task);
        return tasks.stream().map(Task::getTitle).collect(toSet());
    }

    public Map<String, Task> collectToMap(List<Task> tasks) {
        return tasks.stream().collect(toMap(Task::getTitle, Function.identity()));
    }

    /*
    Example of maxBy
     */
    public Task taskWithLongestTitle(List<Task> tasks) {
        return tasks.stream().collect(collectingAndThen(maxBy((t1, t2) -> t1.getTitle().length() - t2.getTitle().length()), Optional::get));
    }

    /*
        example of summingInt
     */
    public int totalTagCount(List<Task> tasks) {
        return tasks.stream().collect(summingInt(t -> t.getTags().size()));
    }

    /*
        summarizingInt
     */
    public IntSummaryStatistics summarizeTitleLength(List<Task> tasks) {
        return tasks.stream().collect(summarizingInt(t -> t.getTitle().length()));
    }

    /*
        joining
     */
    public String titleSummary(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(joining("\n", "<<<<<<>>>>>>>>>\n", "\n<<<<<<>>>>>>>>>"));
    }

}
