package io.shekhar.trainings.java8.why_functional;

public class NaturalNumbers_Functional {

	public static void main(String[] args) {
		naturalNumbers(1, 10000);
	}

	public static void naturalNumbers(int number, int count) {
		if (count > 0) {
			System.out.println(number);
			naturalNumbers((number + 1), (count - 1));
		}
	}

}
