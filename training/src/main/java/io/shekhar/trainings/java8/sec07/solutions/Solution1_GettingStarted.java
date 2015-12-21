package io.shekhar.trainings.java8.sec07.solutions;

import java.time.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Solution1_GettingStarted {

    public LocalDate modiDateOfBirth() {
        return LocalDate.of(1950, Month.SEPTEMBER, 17);
    }

    public LocalTime modiBirthTime() {
        return LocalTime.of(11, 00);
    }

    public LocalDateTime modiDateOfBirthAndTime() {
        return LocalDateTime.of(modiDateOfBirth(), modiBirthTime());
    }



    public List<DayOfWeek> modiGovtAnniversaryDays() {
        LocalDate anniversaryDate = LocalDate.of(2014, Month.MAY, 26);
        List<DayOfWeek> anniversaryDays = Stream.iterate(anniversaryDate, localDate -> localDate.plusYears(1))
                .limit(5)
                .map(localDate -> localDate.getDayOfWeek())
                .collect(toList());
        return anniversaryDays;
    }
}
