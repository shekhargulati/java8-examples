package io.shekhar.trainings.java8.api_design;

/**
 * Created by shekhargulati on 20/09/15.
 */
        public class App1 implements A {
            @Override
            public void doSth() {
                System.out.println("inside App1");
            }

            public static void main(String[] args) {
                new App1().doSth();
            }
        }

        interface A {
            default void doSth() {
                System.out.println("inside A");
            }
        }
