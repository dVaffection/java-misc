package open_data_structures;

public class SLList<T> implements Deque<T> {

    private int  n; // number of elements
    private Node head;
    private Node tail;

    @Override
    public void push(T o) {
        Node node = new Node(o);

        if (n == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }

        n++;
    }

    @Override
    public T pop() {
        T o;

        if (n == 0) {
            o = null;
        } else {
            o = head.value;
            head = head.next;
            n--;

            if (n == 0) {
                tail = null;
            }
        }

        return o;
    }

    @Override
    public void enqueue(T o) {
        Node node = new Node(o);

        if (n == 0) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;

        n++;
    }

    @Override
    public T dequeue() {
        return pop();
    }

    class Node {

        T    value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
