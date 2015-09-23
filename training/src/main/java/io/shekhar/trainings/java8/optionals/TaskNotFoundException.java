package io.shekhar.trainings.java8.optionals;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String id) {
        super("No task found for id: " + id);
    }
}
