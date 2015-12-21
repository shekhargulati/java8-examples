package io.shekhar.trainings.java8.sec03.exercises.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Solution3_MethodReferences {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<LocalDate> taskCreationDates = filterAndExtract(tasks, task -> task.getType() == TaskType.BLOGGING, Task::getCreatedOn);
        filterAndExtract(tasks, task -> task.getType() == TaskType.BLOGGING, TaskExtractor.identityOp());
        taskCreationDates.forEach(System.out::println);

    }

    private static <T> List<T> filterAndExtract(List<Task> tasks, Predicate<Task> predicate, TaskExtractor<T> extractor) {
        List<T> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (predicate.test(task)) {
                readingTasks.add(extractor.apply(task));
            }
        }
        return readingTasks;
    }
}

@FunctionalInterface
interface TaskExtractor<T> extends Function<Task, T> {

    static TaskExtractor<Task> identityOp() {
        return t -> t;
    }

}