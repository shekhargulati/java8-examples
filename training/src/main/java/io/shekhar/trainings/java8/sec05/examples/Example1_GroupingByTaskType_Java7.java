package io.shekhar.trainings.java8.sec05.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example1_GroupingByTaskType_Java7 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        Map<TaskType, List<Task>> allTasksByType = new HashMap<>();
        for (Task task : tasks) {
            List<Task> existingTasksByType = allTasksByType.get(task.getType());
            if (existingTasksByType == null) {
                List<Task> tasksByType = new ArrayList<>();
                tasksByType.add(task);
                allTasksByType.put(task.getType(), tasksByType);
            } else {
                existingTasksByType.add(task);
            }
        }
        for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
            System.out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
        }
    }


}
