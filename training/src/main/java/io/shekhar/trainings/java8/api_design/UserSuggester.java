package io.shekhar.trainings.java8.api_design;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by shekhargulati on 20/09/15.
 */
public interface UserSuggester {

    List<String> suggestions(String initials);


    //List<String> suggestions(String initials, Predicate<String> predicate);

    /*default List<String> suggestions(String initials, Predicate<String> predicate) {
        return suggestions(initials).stream().filter(predicate).collect(toList());
    }*/

    static UserSuggester getInstance() {
        return new DefaultUserSuggester();
    }
}
