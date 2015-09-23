package io.shekhar.trainings.java8.date_time.examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example1_GettingStarted {

    public LocalDate modiDateOfBirth() {
        return LocalDate.now();
    }

    public LocalTime modiBirthTime() {
        return LocalTime.now();
    }

    public LocalDateTime modiDateOfBirthAndTime() {
        return LocalDateTime.now();
    }

    // iterate, dayOfWeek
    public List<DayOfWeek> modiGovtAnniversaryDays() {
        return Collections.emptyList();
    }
}
