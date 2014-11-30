package exercises.search;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {

    private Node root = new Node("");

    public void add(String value, String to) {
        Node parent = findNode(to);

        if (parent == null) {
            String message = String.format("Parent \"%s\" was not found", to);
            throw new RuntimeException(message);
        }

        parent.children.add(new Node(value));
    }

    public String find(String value) {
        Node node = findNode(value);
        if (node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    private Node findNode(String value) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            Node node = queue.poll();
            if (node == null) {
                return null;
            }

            if (value.equals("h")) {
                System.out.println(node.value);
            }

            if (node.value.equals(value)) {
                return node;
            }

            for (Node child : node.children) {
                queue.add(child);
            }
        }
    }

    private class Node {

        public String value;
        public Collection<Node> children = new LinkedList<>();

        private Node(String value) {
            this.value = value;
        }
    }

}
