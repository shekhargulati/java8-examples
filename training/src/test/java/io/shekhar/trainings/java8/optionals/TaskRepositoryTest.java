package io.shekhar.trainings.java8.optionals;

import io.shekhar.trainings.java8.optionals.domain.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class TaskRepositoryTest {

    private TaskRepository repository = new TaskRepository();

    @Before
    public void setUp() throws Exception {
        repository.loadData();
    }

    @Test
    public void findTaskInRepository() throws Exception {
        Task task = repository.find("1");
        assertNotNull(task);
    }

    @Test
    public void findAssignedUser() throws Exception {
        Optional<String> username = repository.taskAssignedTo("1");
        assertFalse(username.isPresent());

    }
}