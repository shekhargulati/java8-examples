package io.shekhar.trainings.java8.collectors.examples;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example3_GroupingTest {

    private Example3_Grouping example = new Example3_Grouping();

    @Test
    public void groupTaskByType() throws Exception {
        List<Task> tasks = getTasks();
        Map<TaskType, List<Task>> taskByType = example.groupByType(tasks);
        assertThat(taskByType.get(TaskType.READING), hasSize(2));
    }

    @Test
    public void groupTaskTitleByType() throws Exception {
        List<Task> tasks = getTasks();
        Map<TaskType, List<String>> taskByType = example.groupTaskTitleByType(tasks);
        assertThat(taskByType.get(TaskType.READING), hasSize(2));
    }

    @Test
    public void groupTasksByTag() throws Exception {
        List<Task> tasks = getTasks();
        Map<String, List<Task>> tasksByTag = example.groupByTag(tasks);
//        tasksByTag.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
        assertThat(tasksByTag.get("java8"), hasSize(2));
    }

    @Test
    public void groupTaskByTypeAndCreationDate() throws Exception {
        List<Task> tasks = getTasks();
        Map<TaskType, Map<LocalDate, List<String>>> taskMap = example.groupByTypeAndCreationDate(tasks);
//        taskMap.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
        assertThat(taskMap, hasEntry(equalTo(TaskType.CODING), hasKey(LocalDate.of(2015, Month.SEPTEMBER, 20))));
        assertThat(taskMap, hasEntry(equalTo(TaskType.BLOGGING), hasKey(LocalDate.of(2015, Month.SEPTEMBER, 21))));
        assertThat(taskMap, hasEntry(equalTo(TaskType.READING), hasKey(LocalDate.of(2015, Month.SEPTEMBER, 20))));
    }

    @Test
    public void groupTaskTypeWithTaskWithLongestLength() throws Exception {
        List<Task> tasks = getTasks();
        Map<TaskType, Optional<Task>> map = example.groupTaskTypeWithTaskWithLongestLength(tasks);
        map.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
        assertThat(map, hasKey(TaskType.BLOGGING));
        assertThat(map, hasKey(TaskType.CODING));
        assertThat(map, hasKey(TaskType.READING));

        Map<TaskType, String> taskTypeStringMap = example.groupTaskTypeWithTaskWithLongestTitle(tasks);
        assertThat(taskTypeStringMap, hasEntry(equalTo(TaskType.BLOGGING), equalTo("Write a blog on Stream API")));
    }
}