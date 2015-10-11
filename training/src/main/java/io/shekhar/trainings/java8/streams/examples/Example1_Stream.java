package io.shekhar.trainings.java8.streams.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.List;
import java.util.stream.Collectors;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example1_Stream {
    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<String> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())
                .map(Task::getTitle)
                .collect(Collectors.toList());
        readingTasks.forEach(System.out::println);
    }
}
