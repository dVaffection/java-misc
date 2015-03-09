package open_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ArrayBasedListTest {

    @Test
    public void test() {
        ArrayBasedList<Character> list = new ArrayBasedList(6);

        // init
        list.add('b');
        list.add('r');
        list.add('e');
        list.add('d');

        assertEquals(6, list.getArraySize());
        assertSame('r', list.get(1));


        // adding
        list.add('e', 2);
        assertEquals(6, list.getArraySize());
        assertSame('e', list.get(2));

        list.add('r', 5);
        assertEquals(6, list.getArraySize());
        assertSame('r', list.get(5));

        list.add('e', 5);
        assertEquals(12, list.getArraySize());
        assertSame('e', list.get(5));


        // removing
        list.remove(4);
        assertEquals(12, list.getArraySize());
        assertSame('e', list.get(4));

        list.remove(4);
        assertEquals(12, list.getArraySize());
        assertSame('r', list.get(4));

        list.remove(4);
        assertEquals(8, list.getArraySize());
        assertSame(null, list.get(4));


        // setting
        list.set('i', 2);
        assertEquals(8, list.getArraySize());
        assertSame('i', list.get(2));
    }
}