package io.shekhar.trainings.java8.collectors.examples;

import io.shekhar.trainings.java8.domain.Task;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example2_ReduceValueTest {

    private Example2_ReduceValue example = new Example2_ReduceValue();

    @Test
    public void shouldCollectAllTitlesToAList() throws Exception {
        List<Task> tasks = getTasks();
        List<String> titles = example.allTitles(tasks);
        assertThat(titles, hasSize(5));
        assertThat(titles, contains(
                "Read Java 8 in action",
                "Write factorial program in Haskell",
                "Read Effective Java",
                "Write a blog on Stream API",
                "Write prime number program in Scala"));
    }

    @Test
    public void shouldCollectUniqueTitles() throws Exception {
        List<Task> tasks = getTasks();
        Set<String> titles = example.uniqueTitle(tasks);
        assertThat(titles, hasSize(5));
    }

    @Test
    public void shouldCollectToMap() throws Exception {
        Map<String, Task> map = example.collectToMap(getTasks());
        assertThat(map.size(), equalTo(5));
        map.forEach((k, v) -> System.out.println(String.format("%s =>> %s", k, v)));
    }

    @Test
    public void findTaskWithLongestTitle() throws Exception {
        List<Task> tasks = getTasks();
        Task task = example.taskWithLongestTitle(tasks);
        assertNotNull(task);
        assertThat(task.getTitle(), equalTo("Write prime number program in Scala"));
    }

    @Test
    public void findTotalNumberOfTags() throws Exception {
        List<Task> tasks = getTasks();
        int count = example.totalTagCount(tasks);
        assertThat(count, equalTo(14));
    }

    @Test
    public void shouldProduceSummaryOfTitleLength() throws Exception {
        List<Task> tasks = getTasks();
        IntSummaryStatistics statistics = example.summarizeTitleLength(tasks);
        assertNotNull(statistics);
        assertThat(statistics.getAverage(), equalTo(27.0));
        assertThat(statistics.getCount(), equalTo(5L));
        assertThat(statistics.getMax(), equalTo(35));
        assertThat(statistics.getSum(), equalTo(135L));
    }

    @Test
    public void shouldProduceTitleSummary() throws Exception {
        List<Task> tasks = getTasks();
        String summary = example.titleSummary(tasks);
        System.out.println(summary);
        assertThat(summary, containsString("program in Scala"));
    }
}