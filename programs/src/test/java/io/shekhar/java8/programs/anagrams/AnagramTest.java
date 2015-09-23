package io.shekhar.java8.programs.anagrams;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 23/09/15.
 */
public class AnagramTest {

    private final Anagram_Java8 program = new Anagram_Java8();

    @Test
    public void shouldFindAnagrams() throws Exception {
        Map<String, List<String>> groups = program.anagramGroups("src/main/resources/unixdict.txt");
        assertThat(groups.size(), equalTo(23566));
    }
}