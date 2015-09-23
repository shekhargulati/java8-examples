package io.shekhar.java8.programs.anagrams;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Two or more words can be composed of the same characters, but in a different order.
 * Using the word list at http://www.puzzlers.org/pub/wordlists/unixdict.txt,
 * find the sets of words that share the same characters that contain the most words in them.
 */
public class AnagramTest {

    private final Anagram_Java8 program = new Anagram_Java8();

    @Test
    public void shouldFindAnagrams() throws Exception {
        Map<String, List<String>> groups = program.anagramGroups("src/main/resources/unixdict.txt");
        assertThat(groups.size(), equalTo(23566));
    }

    @Test
    public void findTheMaxAnagramWithItsCount() throws Exception {
        Map.Entry<String, Long> result = program.anagramWithMaxElements("src/main/resources/unixdict.txt");
        assertThat(result.getKey(), equalTo("eilv"));
        assertThat(result.getValue(), equalTo(5L));

    }
}