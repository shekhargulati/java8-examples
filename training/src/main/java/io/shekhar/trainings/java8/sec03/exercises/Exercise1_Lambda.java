package io.shekhar.trainings.java8.sec03.exercises;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Exercise1_Lambda {
    private interface StringToIntConverter {
        int convert(String str) throws NumberFormatException;
    }

    private interface MessageSender {
        void send(String message);
    }

    private interface StringCheck {
        boolean check(String str);
    }

    public static void main(String[] args) {

    }

    public static void doSth(String str, StringToIntConverter converter) {
        System.out.println(converter.convert(str));
    }

    public static void sendEmail(String message, MessageSender sender) {
        sender.send(message);
    }

    public static void check(String str, StringCheck check) {
        System.out.println(check.check(str));
    }

}
