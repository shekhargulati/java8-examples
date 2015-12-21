package io.shekhar.trainings.java8.sec07;

import io.shekhar.trainings.java8.sec07.examples.Example5_Timezone;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Example5_TimezoneTest {

    private Example5_Timezone example = new Example5_Timezone();

    @Test
    public void modiAndObamaTimeOffset() throws Exception {
        String offset = example.modiObamaHourOffset();
        assertThat(offset, is(equalTo("10:30")));
    }
}