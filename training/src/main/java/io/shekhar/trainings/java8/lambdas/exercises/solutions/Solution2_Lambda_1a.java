package io.shekhar.trainings.java8.lambdas.exercises.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;
import io.shekhar.trainings.java8.utils.DataUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Solution2_Lambda_1a {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<String> taskTitles = taskTitles(tasks, TaskType.BLOGGING);

        taskTitles.forEach(System.out::println);
    }

    public static List<String> taskTitles(List<Task> tasks, TaskType type) {
        List<String> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == type) {
                readingTasks.add(task.getTitle());
            }
        }
        return readingTasks;
    }
}
