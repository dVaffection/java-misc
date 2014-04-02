package exercises;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class SetsTest {

    Sets sets;

    @Before
    public void setUp() {
        sets = new Sets();
    }

    @Test
    public void orderedNoStringDuplicates() {
        Collection<String> c = Arrays.asList("d", "d", "c", "a", "b", "a", "c");
        Collection<String> actual = sets.orderedNoDuplicates(c);
        Collection<String> expected = new TreeSet<>(Arrays.asList("a", "b", "c", "d"));

        assertEquals(expected, actual);
    }

    @Test
    public void orderedNoIntegerDuplicates() {
        Collection<Integer> c = Arrays.asList(4, 4, 3, 1, 2, 4, 2, 1);
        Collection<Integer> actual = sets.orderedNoDuplicates(c);
        Collection<Integer> expected = new TreeSet<>(Arrays.asList(1, 2, 3, 4));

        assertEquals(expected, actual);
    }
}
