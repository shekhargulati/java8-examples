package io.shekhar.trainings.java8.lambdas.exercises;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;
import io.shekhar.trainings.java8.utils.DataUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Exercise2_Lambda {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<String> readingTaskTitles = readingTaskTitles(tasks);

        readingTaskTitles.forEach(new Consumer<String>() {
            @Override
            public void accept(String title) {
                System.out.println(title);
            }
        });
    }

    public static List<String> readingTaskTitles(List<Task> tasks) {
        List<String> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTasks.add(task.getTitle());
            }
        }
        return readingTasks;
    }
}
