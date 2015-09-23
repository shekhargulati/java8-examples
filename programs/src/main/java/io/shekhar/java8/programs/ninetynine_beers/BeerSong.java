package io.shekhar.java8.programs.ninetynine_beers;

/**
 * In this puzzle, write code to print out the entire "99 bottles of beer on the wall" song.
 * For those who do not know the song, the lyrics follow this form:
 * 99 bottles of beer on the wall
 * 99 bottles of beer
 * Take one down, pass it around
 * 99 bottles of beer on the wall
 * 98 bottles of beer on the wall
 * ...
 * Take one down, pass it around
 * 0 bottles of beer on the wall
 */
public class BeerSong {

    public static final String FIRST_LINE = "%d bottles of beer on the wall";
    public static final String SECOND_LINE = "%d bottles of beer";
    public static final String THIRD_LINE = "Take one down, pass it around";
    public static final String FOURTH_LINE = "%d bottles of beer on the wall";

    public String song(final int numberOfBeers) {
        return messageBuilder(FIRST_LINE, SECOND_LINE, numberOfBeers).append("\n").append(_song(numberOfBeers - 1, new StringBuilder())).toString();
    }

    private String _song(final int numberOfBeers, StringBuilder builder) {
        if (numberOfBeers < 0) {
            return builder.toString();
        }
        return builder.append(_song(numberOfBeers - 1, messageBuilder(THIRD_LINE, FOURTH_LINE, numberOfBeers))).toString();
    }

    private StringBuilder messageBuilder(String first, String second, final int numberOfBeers) {
        return new StringBuilder(String.format(first, numberOfBeers))
                .append("\n")
                .append(String.format(second, numberOfBeers)).append("\n");
    }
}
