package io.shekhar.trainings.java8.tmp;

public class TaskBuilder {
    private String title;

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Task createTask() {
        return new Task(title);
    }

    public static void main(String[] args) {
        new TaskBuilder().setTitle("hello").createTask();
    }
}