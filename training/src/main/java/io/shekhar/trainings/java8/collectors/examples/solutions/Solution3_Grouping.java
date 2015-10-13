package io.shekhar.trainings.java8.collectors.examples.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * Created by shekhargulati on 20/09/15.
 * Group task by tags
 */
public class Solution3_Grouping {

    public Map<TaskType, List<Task>> groupByType(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType));
    }

    public Map<TaskType, List<String>> groupTaskTitleByType(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType, mapping(Task::getTitle, toList())));
    }

    public Map<String, List<Task>> groupByTag(List<Task> tasks) {
        Map<String, List<Task>> tasksByType = tasks.stream()
                .flatMap(task -> task.getTags().stream().map((String tag) -> new SimpleEntry<>(tag, task)))
                .collect(groupingBy(SimpleEntry::getKey, mapping(SimpleEntry::getValue, toList())));
        return tasksByType;
    }

    public Map<TaskType, Map<LocalDate, List<String>>> groupByTypeAndCreationDate(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType, groupingBy(Task::getCreatedOn, mapping(Task::getTitle, toList()))));
    }

    public Map<TaskType, Optional<Task>> groupTaskTypeWithTaskWithLongestLength(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType, maxBy((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())));
    }

    public Map<TaskType, String> groupTaskTypeWithTaskWithLongestTitle(List<Task> tasks) {
        Comparator<Task> comparator = (t1, t2) -> t1.getTitle().length() - t2.getTitle().length();
        return tasks.stream().collect(groupingBy(Task::getType, collectingAndThen(maxBy(comparator), op -> op.map(Task::getTitle).get())));
    }
}
