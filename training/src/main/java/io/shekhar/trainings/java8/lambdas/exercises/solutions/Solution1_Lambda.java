package io.shekhar.trainings.java8.lambdas.exercises.solutions;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class Solution1_Lambda {
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
        doSth("1", str -> Integer.parseInt(str));
//        doSth("abc", str -> Integer.parseInt(str));

        sendEmail("Learning Java 8", message -> System.out.println("Sending email with message >> " + message));

        check("hello", str -> str.length() > 0);
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
