package io.shekhar.trainings.java8.sec07.examples;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example5_Timezone {

    public String modiObamaHourOffset() {
        ZonedDateTime modiNow = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime obamaNow = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        int seconds = modiNow.getOffset().getTotalSeconds() - obamaNow.getOffset().getTotalSeconds();
        int hours = seconds / (60 * 60);
        int minutes = (seconds - hours * 3600) / 60;
        return String.format("%s:%s", hours, minutes);
    }
}
