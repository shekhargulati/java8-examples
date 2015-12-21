package io.shekhar.trainings.java8.sec07;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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

    @Test
    public void kalamDateOfBirthFormattedInIndianDateFormat() throws Exception {
        final String indianDateFormat = "dd-MM-YYYY";
        String dateOfBirth = kalam.formatDateOfBirth(indianDateFormat);
        assertThat(dateOfBirth, is(equalTo("15-10-1931")));
    }

    @Test
    public void kalamDateOfBirthInDifferentDateFormats() throws Exception {
        LocalDate kalamDateOfBirth = LocalDate.of(1931, Month.OCTOBER, 15);
        assertThat(kalamDateOfBirth.format(DateTimeFormatter.BASIC_ISO_DATE), is(equalTo("19311015")));
        assertThat(kalamDateOfBirth.format(DateTimeFormatter.ISO_LOCAL_DATE), is(equalTo("1931-10-15")));
        assertThat(kalamDateOfBirth.format(DateTimeFormatter.ISO_ORDINAL_DATE), is(equalTo("1931-288")));
    }

    @Test
    public void shouldParseKalamDateOfBirthAndTimeToLocalDateTime() throws Exception {
        final String input = "15 Oct 1931 01:15 AM";
        LocalDateTime dateOfBirthAndTime = kalam.parseDateOfBirthAndTime(input);
        assertThat(dateOfBirthAndTime.toString(), is(equalTo("1931-10-15T01:15")));
    }

    @Test
    public void temporalAdjustersPlayground() throws Exception {
        LocalDate date = LocalDate.of(2015, Month.OCTOBER, 25);
        System.out.println(date);// This will print 2015-10-25
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth); // This will print 2015-10-01
        LocalDate firstDayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayOfNextMonth);// This will print 2015-11-01
        LocalDate lastFridayOfMonth = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println(lastFridayOfMonth); // This will print 2015-10-30
    }
}
