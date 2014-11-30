package careercup;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExercisesTest {

    @Test
    public void areAllCharactersUniqueTrue() {
        String input = "abcd";
        boolean actual = StringExercises.areAllCharactersUnique(input);

        assertTrue(actual);
    }

    @Test
    public void areAllCharactersUniqueFalse() {
        String input = "abbd";
        boolean actual = StringExercises.areAllCharactersUnique(input);

        assertFalse(actual);
    }

    @Test
    public void reverseString() {
        String input = "abcd";
        String actual = StringExercises.reverseString(input);
        String expected = "dcba";

        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicateCharacters() {
        String input = "abbcd";
        String actual = StringExercises.removeDuplicateCharacters(input);
        String expected = "abcd";

        assertEquals(expected, actual);
    }

    @Test
    public void areAnagramsTrue() {
        String first = "mary";
        String second = "army";

        boolean actual = StringExercises.areAnagrams(first, second);
        assertTrue(actual);
    }

    @Test
    public void areAnagramsFalse() {
        String first = "sun";
        String second = "nuts";

        boolean actual = StringExercises.areAnagrams(first, second);
        assertFalse(actual);
    }

    @Test
    public void zerofillMatrixRowAndColumnOnZero() {
        int[][] matrix = {
                {11, 12, 13},
                {21, 0, 23},
                {31, 32, 33},
        };

        int[][] actual = StringExercises.zerofillMatrixRowAndColumnOnZero(matrix);
        int[][] expected = {
                {11, 0, 13},
                {0, 0, 0},
                {31, 0, 33},
        };

        assertTrue(Arrays.deepEquals(expected, actual));
    }
}