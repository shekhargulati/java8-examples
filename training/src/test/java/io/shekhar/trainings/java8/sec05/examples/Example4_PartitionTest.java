package io.shekhar.trainings.java8.sec05.examples;

import io.shekhar.trainings.java8.domain.Task;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class Example4_PartitionTest {

    Example4_Partition example = new Example4_Partition();

    @Test
    public void shouldPartitionTasksByDueDate() throws Exception {
        List<Task> tasks = getTasks();
        Map<Boolean, List<Task>> map = example.dueTasks(tasks);
        map.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
        assertThat(map.get(true), hasSize(equalTo(3)));
        assertThat(map.get(false), hasSize(equalTo(2)));
    }
}