package io.shekhar.trainings.java8.sec07;

import io.shekhar.trainings.java8.sec07.examples.Example1_GettingStarted;
import org.junit.Test;

import java.time.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example1_GettingStartedTest {

    Example1_GettingStarted example = new Example1_GettingStarted();

    @Test
    public void modiDateOfBirthIs17Sept1950() throws Exception {
        LocalDate dob = example.modiDateOfBirth();
        assertThat(dob.getYear(), is(equalTo(1950)));
        assertThat(dob.getMonth(), is(equalTo(Month.SEPTEMBER)));
        assertThat(dob.getDayOfMonth(), is(equalTo(17)));
        assertThat(dob.getDayOfYear(), is(equalTo(260)));
    }

    @Test
    public void modiWasBornOn11Am() throws Exception {
        LocalTime birthTime = example.modiBirthTime();
        assertThat(birthTime.isBefore(LocalTime.NOON), equalTo(true));
    }

    @Test
    public void modiWasBornOn17Sept1950At11am() throws Exception {
        LocalDateTime dobt = example.modiDateOfBirthAndTime();
        assertThat(dobt.getYear(), is(equalTo(1950)));
        assertThat(dobt.getMonth(), is(equalTo(Month.SEPTEMBER)));
        assertThat(dobt.getDayOfMonth(), is(equalTo(17)));
        assertThat(dobt.toLocalTime().isBefore(LocalTime.NOON), equalTo(true));
    }

    @Test
    public void findAllDaysOfWeekOfModiGovernmentAnniversary() throws Exception {
        List<DayOfWeek> anniversaryDays = example.modiGovtAnniversaryDays();
        assertThat(anniversaryDays, contains(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    }
}