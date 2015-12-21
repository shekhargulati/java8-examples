package io.shekhar.trainings.java8.sec07.examples;

import java.time.*;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example3_DurationAndPeriod {

    public long modiDaysInOffice(LocalDateTime now) {
        LocalDateTime joiningDate = LocalDateTime.of(2014, Month.MAY, 26, 0, 0);
        return Duration.between(joiningDate, now).toDays();
    }

    public String modiGovtPeriod(LocalDate now) {
        LocalDate officeJoiningDate = LocalDate.of(2014, Month.MAY, 26);
        Period p = Period.between(officeJoiningDate, now);
        return String.format("%d year(s) >> %d month(s) >> %d day(s)", p.getYears(), p.getMonths(), p.getDays());
    }
}
