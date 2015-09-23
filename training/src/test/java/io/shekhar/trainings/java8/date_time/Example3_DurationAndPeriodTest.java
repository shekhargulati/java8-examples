package io.shekhar.trainings.java8.date_time;

import io.shekhar.trainings.java8.date_time.examples.Example3_DurationAndPeriod;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example3_DurationAndPeriodTest {

    private Example3_DurationAndPeriod example = new Example3_DurationAndPeriod();

    @Test
    public void modiGovtPeriod() throws Exception {
        String period = example.modiGovtPeriod(LocalDate.now());
        System.out.println(period);
    }

    @Test
    public void modiNumberOfDaysInOffice() throws Exception {
        long days = example.modiDaysInOffice(LocalDateTime.now());
        assertThat(days, greaterThan(100L));

    }
}