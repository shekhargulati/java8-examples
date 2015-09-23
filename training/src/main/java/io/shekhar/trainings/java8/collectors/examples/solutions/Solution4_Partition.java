package io.shekhar.trainings.java8.collectors.examples.solutions;

import io.shekhar.trainings.java8.domain.Task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class Solution4_Partition {

    public Map<Boolean, List<Task>> dueTasks(List<Task> tasks) {
        LocalDate trainingDay = LocalDate.of(2015, Month.SEPTEMBER, 21);
        return tasks.stream().collect(partitioningBy(t -> t.getCreatedOn().isEqual(trainingDay) || t.getCreatedOn().isAfter(trainingDay)));
    }
}
