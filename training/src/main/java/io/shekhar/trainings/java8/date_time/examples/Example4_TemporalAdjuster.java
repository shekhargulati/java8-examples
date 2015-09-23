package io.shekhar.trainings.java8.date_time.examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example4_TemporalAdjuster {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.with(TemporalAdjusters.firstDayOfNextMonth()));

        LocalDate nextWorkingDay = today.with(TemporalAdjusters.ofDateAdjuster(localDate -> {
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                return localDate.plusDays(3);
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                return localDate.plusDays(2);
            }
            return localDate.plusDays(1);
        }));

        System.out.println(nextWorkingDay);
    }
}
