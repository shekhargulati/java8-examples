package io.shekhar.trainings.java8.sec01;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BasicCalculatorTest {

    @Test
    public void shouldAddTwoNumbers_code_to_interface() throws Exception {
        Calculator calculator = new BasicCalculator();
        int sum = calculator.add(1, 2);
        assertThat(sum, equalTo(3));
    }

    @Test
    public void shouldAddTwoNumbers_code_to_implementation() throws Exception {
        BasicCalculator calculator = new BasicCalculator();
        int sum = calculator.add(1, 2);
        assertThat(sum, equalTo(3));
    }
}