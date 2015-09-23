package io.shekhar.trainings.java8.why_functional;

public class NaturalNumbers_Imperative {
	
	public static void main(String[] args) {
		naturalNumbers(1, 10);
	}

	public static void naturalNumbers(int number, int count){
		for (int i = 0; i < count; i++) {
			System.out.println(number);
			number++;
		}
	}

}
