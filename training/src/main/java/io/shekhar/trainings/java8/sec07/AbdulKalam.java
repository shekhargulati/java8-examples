package io.shekhar.trainings.java8.sec07;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AbdulKalam {
    public LocalDate dateOfBirth() {
        return LocalDate.of(1931, Month.OCTOBER, 15);
    }

    public LocalTime timeOfBirth() {
        return LocalTime.of(1, 15);
    }

    public LocalDateTime dateOfBirthAndTime() {
        return LocalDateTime.of(dateOfBirth(), timeOfBirth());
    }

    public DayOfWeek dayOfBirthAtAge(final int age) {
        return dateOfBirth().plusYears(age).getDayOfWeek();
    }


    public List<DayOfWeek> allBirthDateDayOfWeeks(int limit) {
        return Stream.iterate(dateOfBirth(), db -> db.plusYears(1))
                .map(LocalDate::getDayOfWeek)
                .limit(limit)
                .collect(toList());
    }


    public Duration kalamLifeDuration() {
        LocalDateTime deathDateAndTime = LocalDateTime.of(LocalDate.of(2015, Month.JULY, 27), LocalTime.of(19, 0));
        return Duration.between(dateOfBirthAndTime(), deathDateAndTime);
    }

    public long numberOfDaysLived() {
        return kalamLifeDuration().toDays();
    }

    public Period kalamLifePeriod() {
        LocalDate deathDate = LocalDate.of(2015, Month.JULY, 27);
        return Period.between(dateOfBirth(), deathDate);
    }

    public String formatDateOfBirth(final String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateOfBirth().format(formatter);
    }

    public LocalDateTime parseDateOfBirthAndTime(String input) {
        return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a"));
    }
}