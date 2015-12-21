package io.shekhar.trainings.java8.sec03.exercises.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Solution2_Lambda_1c {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<String> bloggingTasks = taskTitles(tasks, task -> task.getType() == TaskType.BLOGGING);

        bloggingTasks.forEach(System.out::println);
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
