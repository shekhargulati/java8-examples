package io.shekhar.trainings.java8.date_time.examples;

import java.time.Instant;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class Example2_Instant {

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(3);
        System.out.println(instant);//1970-01-01T00:00:03Z

        Instant now = Instant.now();
        System.out.println(now);//2015-09-19T17:18:18.425Z

        System.out.println(Instant.parse("2015-09-12T10:15:30.00Z"));//2015-09-12T10:15:30Z
    }
}
