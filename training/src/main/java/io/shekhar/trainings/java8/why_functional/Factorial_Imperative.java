package io.shekhar.trainings.java8.why_functional;

public class Factorial_Imperative {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    public static int factorial(int number) {
        int factorial = 1;
        if (number == 0) {
            return factorial;
        }
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
