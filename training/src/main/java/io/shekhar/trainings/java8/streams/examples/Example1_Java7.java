package io.shekhar.trainings.java8.streams.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;
import io.shekhar.trainings.java8.utils.DataUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        Collections.sort(readingTasks, (t1, t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()));
        for (Task readingTask : readingTasks) {
            System.out.println(readingTask.getTitle());
        }


    }
}
