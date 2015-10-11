package io.shekhar.trainings.java8.streams.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;
import io.shekhar.trainings.java8.utils.DataUtils;

import java.util.*;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

/**
 * Created by shekhargulati on 17/09/15.
 */
public class Example1_Java7 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<Task> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTasks.add(task);
            }
        }
        Collections.sort(readingTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTitle().length() - t2.getTitle().length();
            }
        });
        for (Task readingTask : readingTasks) {
            System.out.println(readingTask.getTitle());
        }
    }
}
