package io.shekhar.trainings.java8.lambdas.exercises;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Exercise3_MethodReferences {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        taskTitles(tasks, task -> task.getType() == TaskType.BLOGGING)
                .forEach(t -> System.out.println(t));
    }

    public static List<String> taskTitles(List<Task> tasks, Predicate<Task> predicate) {
        List<String> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (predicate.test(task)) {
                readingTasks.add(task.getTitle());
            }
        }
        return readingTasks;
    }

}
