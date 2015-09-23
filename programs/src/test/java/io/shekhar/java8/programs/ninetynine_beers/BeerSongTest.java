package io.shekhar.java8.programs.ninetynine_beers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.junit.Assert.assertThat;

/**
 * Created by shekhargulati on 23/09/15.
 */
public class BeerSongTest {

    private final BeerSong program = new BeerSong();

    @Test
    public void shouldReturnFirstParaOfSong() throws Exception {
        String song = program.song(1);
        String[] lines = song.split("\n");
        assertThat(lines, arrayWithSize(5));
        assertThat(lines[0], is(equalTo("1 bottles of beer on the wall")));
        assertThat(lines[1], is(equalTo("1 bottles of beer")));
    }

    @Test
    public void shouldCreate99BeerSong() throws Exception {
        String song = program.song(99);
        String[] lines = song.split("\n");
        assertThat(lines, arrayWithSize(201));
    }
}