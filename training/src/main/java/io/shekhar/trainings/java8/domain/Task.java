package io.shekhar.trainings.java8.domain;

import java.time.LocalDate;
import java.util.*;

public class Task {

    private final String title;
    private final String description;
    private final TaskType type;
    private LocalDate createdOn;
    private Set<String> tags = new HashSet<>();

    public Task(final String title, final TaskType type) {
        this(title, title, type, LocalDate.now());
    }

    public Task(final String title, final TaskType type, final LocalDate createdOn) {
        this(title, title, type, createdOn);
    }

    public Task(final String title, final String description, final TaskType type, final LocalDate createdOn) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdOn = createdOn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Task addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return Optional.ofNullable(o)
                .filter(that -> that instanceof Task)
                .map(that -> (Task) that)
                .filter(that -> Objects.equals(this.title, that.title))
                .filter(that -> Objects.equals(this.type, that.type))
                .isPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, createdOn);
    }
}
