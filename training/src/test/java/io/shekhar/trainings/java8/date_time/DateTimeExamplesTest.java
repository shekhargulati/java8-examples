package io.shekhar.trainings.java8.date_time;

import org.junit.Test;

import java.time.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateTimeExamplesTest {

    private AbdulKalam kalam = new AbdulKalam();

    @Test
    public void kalamWasBornOn15October1931() throws Exception {
        LocalDate dateOfBirth = kalam.dateOfBirth();
        assertThat(dateOfBirth.getMonth(), is(equalTo(Month.OCTOBER)));
        assertThat(dateOfBirth.getYear(), is(equalTo(1931)));
        assertThat(dateOfBirth.getDayOfMonth(), is(equalTo(15)));
        assertThat(dateOfBirth.getDayOfYear(), is(equalTo(288)));
    }

    @Test
    public void localDateStaticFactoryMethods() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        System.out.println(today);
        System.out.println(yesterday);
    }

    @Test
    public void kalamWasBornAt0115() throws Exception {
        LocalTime timeOfBirth = kalam.timeOfBirth();
        assertThat(timeOfBirth.toString(), is(equalTo("01:15")));
        assertThat(timeOfBirth.getHour(), is(equalTo(1)));
        assertThat(timeOfBirth.getMinute(), is(equalTo(15)));
        assertThat(timeOfBirth.getSecond(), is(equalTo(0)));
    }

    @Test
    public void kalamWasBornOn15October1931At0115() throws Exception {
        LocalDateTime dobt = kalam.dateOfBirthAndTime();
        assertThat(dobt.toString(), is(equalTo("1931-10-15T01:15")));
    }

    @Test
    public void kalam50thBirthDayWasOnThursday() throws Exception {
        DayOfWeek dayOfWeek = kalam.dayOfBirthAtAge(50);
        assertThat(dayOfWeek, is(equalTo(DayOfWeek.THURSDAY)));
    }

    @Test
    public void findAllDayOfWeekCorrespondingToKalamBirthDate() throws Exception {
        List<DayOfWeek> dayOfWeeks = kalam.allBirthDateDayOfWeeks(84);
        dayOfWeeks.forEach(System.out::println);
    }

    @Test
    public void kalamLived30601Days() throws Exception {
        long daysLived = kalam.numberOfDaysLived();
        assertThat(daysLived, is(equalTo(30601L)));
    }

    @Test
    public void kalamLifePeriod() throws Exception {
        Period kalamLifePeriod = kalam.kalamLifePeriod();
        assertThat(kalamLifePeriod.getYears(), is(equalTo(83)));
        assertThat(kalamLifePeriod.getMonths(), is(equalTo(9)));
        assertThat(kalamLifePeriod.getDays(), is(equalTo(12)));
    }
}
