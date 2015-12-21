package io.shekhar.trainings.java8.sec01.solution;

public abstract class CalculatorFactory {

    public static Calculator getInstance() {
        return new BasicCalculator();
    }
}
