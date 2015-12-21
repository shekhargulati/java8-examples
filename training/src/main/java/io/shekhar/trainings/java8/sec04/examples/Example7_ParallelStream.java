package io.shekhar.trainings.java8.sec04.examples;

import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Example7_ParallelStream {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> urls = Arrays.asList(
                "http://shekhargulati.com/",
                "http://shekhargulati.com/30-technologies-in-30-days/",
                "http://shekhargulati.com/7-days-with-java-8/",
                "http://shekhargulati.com/my-books/",
                "http://shekhargulati.com/2015/09/19/word-count-example-in-java-8/",
                "http://shekhargulati.com/2014/10/31/writing-your-first-technology-book-some-useful-lessons/");

        urls.parallelStream().map(url -> toTitle(url)).forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total time taken %d(secs)", (endTime - startTime) / 1000));
    }

    private static String toTitle(String url) {
        try {
            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(url));
            final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            return doc.getTitle();
        } catch (Exception e) {
            return "404 not found";
        }
    }
}
