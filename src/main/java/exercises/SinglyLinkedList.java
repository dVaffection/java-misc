package exercises;

public class SinglyLinkedList<T extends Comparable<T>> {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void add(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (true) {
                if (current.next == null) {
                    current.next = new Node(value);
                    break;
                }

                current = current.next;
            }
        }
    }

    public Node mergeLists(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.value.compareTo(node2.value) == -1) {
            node1.next = mergeLists(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeLists(node2.next, node1);
            return node2;
        }
    }

    public void reverse() {
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;
    }

    @Override
    public String toString() {
        return getDump(head);
    }

    public String getDump(Node node) {
        String dump = "";

        while (node != null) {
            dump += node.value + ", ";
            node = node.next;
        }

        return dump;
    }

    class Node {

        T    value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

}
