package io.shekhar.trainings.java8.sec03.exercises;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

/**
 * Refactor code shown below to Java 8
 * 1. Use lambdas wherever possible
 * 2. Use method references wherever possible
 * 3. Use Extractor
 */
public class Exercise_Lambdas {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        List<String> titles = taskTitles(tasks);
        titles.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public static List<String> taskTitles(List<Task> tasks) {
        List<String> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTitles.add(task.getTitle());
            }
        }
        return readingTitles;
    }

}


