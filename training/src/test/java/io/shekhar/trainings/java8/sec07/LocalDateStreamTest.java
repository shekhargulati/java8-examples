package io.shekhar.trainings.java8.sec07;

import io.shekhar.trainings.java8.sec07.examples.LocalDateStream;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by shekhargulati on 19/09/15.
 */
public class LocalDateStreamTest {

    @Test
    public void shouldCreateStreamOfLocalDate() throws Exception {
        LocalDateStream.stream(LocalDate.now()).limit(10).forEach(System.out::println);
    }
}