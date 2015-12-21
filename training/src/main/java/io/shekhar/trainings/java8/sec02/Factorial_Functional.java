package io.shekhar.trainings.java8.sec02;

public class Factorial_Functional {

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}

	public static int factorial(int number) {
		if (number == 0) {
			return 1;
		}
		return number * factorial(number-1);
	}

}
