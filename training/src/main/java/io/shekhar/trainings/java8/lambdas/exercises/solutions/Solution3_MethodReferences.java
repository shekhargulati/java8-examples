package io.shekhar.trainings.java8.lambdas.exercises.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Solution3_MethodReferences {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        taskTitles(tasks, task -> task.getType() == TaskType.BLOGGING, Task::getCreatedOn)
                .forEach(System.out::println);

    }

    public static <R> List<R> taskTitles(List<Task> tasks, Predicate<Task> predicate, Function<Task, R> fx) {
        List<R> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (predicate.test(task)) {
                readingTasks.add(fx.apply(task));
            }
        }
        return readingTasks;
    }
}
