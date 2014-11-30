package stackmachine;

public class StackMachine {

    private Node pointer;

    public void push(Object value) {
        Node node = new Node(value);

        if (pointer == null) {
            pointer = node;
        } else {
            node.next = pointer;
            pointer = node;
        }
    }

    public Object pop() {
        Object value = null;

        if (pointer != null) {
            value = pointer.value;
            pointer = pointer.next;
        }

        return value;
    }

    private class Node {

        Object value;
        Node   next;

        public Node(Object value) {
            this.value = value;
        }
    }

}
