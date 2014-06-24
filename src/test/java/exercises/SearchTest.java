package exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchTest {

    @Test(expected = IllegalArgumentException.class)
    public void binaryThrowsException() {
        Integer[] array = {};
        Search.binary(array, 2);
    }

    @Test
    public void binaryArrayHasOneElement() {
        Integer[] array = {5};
        int expected = 0;
        int actual = Search.binary(array, 5);

        assertSame(expected, actual);
    }

    @Test
    public void binaryArrayHasTwoElement() {
        Integer[] array = {5, 10};
        int expected = 1;
        int actual = Search.binary(array, 10);

        assertSame(expected, actual);
    }

    @Test
    public void binaryValueNotFound() {
        Integer[] array = {5, 10};
        int expected = -1;
        int actual = Search.binary(array, 3);

        assertSame(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void binaryNotSortedValues() {
        Integer[] array = {11, 20, 22, 35, 89, 78, 79, 81, 85, 86, 95, 100, 102, 105};
        Search.binary(array, 89);
    }

    @Test
    public void binary() {
        Integer[] array = {11, 20, 22, 35, 46, 78, 79, 81, 85, 86, 95, 100, 102, 105};
        int expected = 4;
        int actual = Search.binary(array, 46);

        assertSame(expected, actual);
    }
}