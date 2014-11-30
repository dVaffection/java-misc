package careercup;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LinkedListExercisesTest {

    @Test
    public void removeDuplicatesFromUnsortedList() {
        List<Integer> list = new LinkedList<>(Arrays.asList(4, 1, 3, 1, 3, 2, 1, 6));
        List<Integer> actual = LinkedListExercises.removeDuplicatesFromUnsortedList(list);
        List<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 6));

        assertEquals(expected, actual);
    }

    @Test
    public void deleteSinglyLinkedListNode() {
        LinkedListExercises.SinglyLinkedList<Integer> list = new LinkedListExercises.SinglyLinkedList(1, 2, 3, 4, 5);
        LinkedListExercises.deleteSinglyLinkedListNode(list, 3);
        LinkedListExercises.SinglyLinkedList<Integer> expected = new LinkedListExercises.SinglyLinkedList(1, 2, 4, 5);

        assertEquals(expected, list);
    }
}