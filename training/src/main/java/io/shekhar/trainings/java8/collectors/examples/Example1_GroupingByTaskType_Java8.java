package io.shekhar.trainings.java8.collectors.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.List;
import java.util.Map;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example1_GroupingByTaskType_Java8 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        Map<TaskType, List<Task>> tasksByType = tasks.stream().collect(groupingBy(Task::getType));
        tasksByType.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
    }
}
