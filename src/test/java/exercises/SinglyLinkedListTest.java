package exercises;

import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void reverse() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1, 2, 3, 4, 5);

        System.out.println(list);

        list.reverse();

        System.out.println(list);
    }

    @Test
    public void mergeLists() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.add(1, 2, 3, 4, 5);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.add(3, 4, 5, 6, 7);

        SinglyLinkedList.Node node = list1.mergeLists(list1.getHead(), list2.getHead());
        System.out.println(list1.getDump(node));
    }

}