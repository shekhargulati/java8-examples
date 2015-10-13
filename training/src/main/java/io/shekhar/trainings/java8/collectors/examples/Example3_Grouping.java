package io.shekhar.trainings.java8.collectors.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by shekhargulati on 20/09/15.
 * Group task by tags
 */
public class Example3_Grouping {

    // collect
    public Map<TaskType, List<Task>> groupByType(List<Task> tasks) {
        return Collections.emptyMap();
    }

    // collect and mapping
    public Map<TaskType, List<String>> groupTaskTitleByType(List<Task> tasks) {
        return Collections.emptyMap();
    }

    // flatmap, collect, grouping, mapping
    public Map<String, List<Task>> groupByTag(List<Task> tasks) {
        return Collections.emptyMap();
    }

    public Map<TaskType, Map<LocalDate, List<String>>> groupByTypeAndCreationDate(List<Task> tasks) {
        return Collections.emptyMap();
    }

    // collect, groupingBy, maxBy
    public Map<TaskType, Optional<Task>> groupTaskTypeWithTaskWithLongestLength(List<Task> tasks) {
        return Collections.emptyMap();
    }

    // collect, groupingBy, collectingAndThen, maxyBy, Optional.map
    public Map<TaskType, String> groupTaskTypeWithTaskWithLongestTitle(List<Task> tasks) {
        /*Comparator<Task> comparator = (t1, t2) -> t1.getTitle().length() - t2.getTitle().length();
        return tasks.stream().collect(groupingBy(Task::getType, collectingAndThen(maxBy(comparator), op -> op.map(Task::getTitle).get())));*/
        return Collections.emptyMap();
    }
}
