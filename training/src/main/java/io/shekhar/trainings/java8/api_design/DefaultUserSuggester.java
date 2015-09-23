package io.shekhar.trainings.java8.api_design;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shekhargulati on 20/09/15.
 */
public class DefaultUserSuggester implements UserSuggester {
    @Override
    public List<String> suggestions(String initials) {
        return Arrays.asList("shekhar");
    }
}
