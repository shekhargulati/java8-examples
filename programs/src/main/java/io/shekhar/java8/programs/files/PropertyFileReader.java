package io.shekhar.java8.programs.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by shekhargulati on 20/10/15.
 */
public class PropertyFileReader {

    public static void main(String[] args) throws Exception {
        Path propertyFilePath = Paths.get("programs", "src", "main", "resources", "myproperties.properties");
        Stream<String> properties = Files.lines(propertyFilePath);
        Pattern ignoreLinesRegex = Pattern.compile("^\\s*(#.*|\\s*)$");
        Pattern keyValueRegex = Pattern.compile("\\s*=\\s*");

        properties
                .filter(prop -> !ignoreLinesRegex.matcher(prop).matches())
                .map(keyValueRegex::split)
                .map(kv -> new SimpleEntry<>(kv[0].trim(), kv[1].trim()))
                .forEach(System.out::println);
    }
}
