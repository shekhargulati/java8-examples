package io.shekhar.trainings.java8.sec03.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by shekhargulati on 17/09/15.
 * Similar to templates used by Spring framework
 */
public class FileTemplate {

    public <T> T execute(File file, Processor<T> processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return processor.process(reader);
        }
    }

    @FunctionalInterface
    private interface Processor<T> {
        public T process(BufferedReader reader) throws IOException;
    }


    public static void main(String[] args) throws Exception {
        FileTemplate template = new FileTemplate();
        String headerLine = template.execute(new File("src/main/resources/names.txt"), reader -> reader.readLine().toUpperCase());
        System.out.println(headerLine);
    }
}
