package io.shekhar.trainings.java8.sec07.examples;

import java.util.Date;

/**
 * Created by shekhargulati on 19/09/15.
 * problems with existing Date API
 */
public class DatePain {

    public static void main(String[] args) {
        Date date = new Date(12, 12, 12);
        System.out.println(date);
    }
}

