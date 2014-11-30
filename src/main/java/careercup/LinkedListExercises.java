package careercup;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LinkedListExercises {

    public static LinkedList<Integer> removeDuplicatesFromUnsortedList(List<Integer> list) {
        Set<Integer> set = new TreeSet<>();

        for (Integer number : list) {
            set.add(number);
        }

        LinkedList<Integer> unique = new LinkedList<>();
        unique.addAll(set);
        return unique;
    }

    public static void deleteSinglyLinkedListNode(SinglyLinkedList<Integer> list, int number) {
        list.delete(number);
    }

    public static class SinglyLinkedList<T> {

        private Node root = new Node();

        public SinglyLinkedList(T... values) {
            Node n = root;
            for (T value : values) {
                n.value = value;
                n.next = new Node();
                n = n.next;
            }
        }

        public void delete(T value) {
            if (root.value.equals(value)) {
                root = root.next;
            } else {
                Node p = root;
                Node n = root.next;
                while (n.next != null) {
                    if (n.value.equals(value)) {
                        p.next = n.next;
                        break;
                    }
                    p = n;
                    n = n.next;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SinglyLinkedList that = (SinglyLinkedList) o;

            return toString().equals(that.toString());
        }

        @Override
        public int hashCode() {
            return root.hashCode();
        }

        @Override
        public String toString() {
            String str = "";

            Node n = root;
            while (n.next != null) {
                str += n.value + ", ";
                n = n.next;
            }

            return str;
        }

        private static class Node<T> {

            public T    value;
            public Node next;
        }
    }

}
