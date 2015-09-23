package io.shekhar.trainings.java8.date_time.examples;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class LocalDateStream {

    /**
     * Generates an infinite sequence of LocalDate starting from the start date.
     *
     * @param start the start date
     * @return infinite Stream of LocalDate
     */
    public static Stream<LocalDate> stream(LocalDate start) {
        return Stream.iterate(start, localDate -> localDate.plusDays(1));
    }

    /**
     * Produce a stream of LocalDate with year incremented by 1
     *
     * @param start
     * @return
     */
    public static Stream<LocalDate> streamOfYearlyLocalDate(LocalDate start) {
        return Stream.iterate(start, localDate -> localDate.plusYears(1));
    }


}
