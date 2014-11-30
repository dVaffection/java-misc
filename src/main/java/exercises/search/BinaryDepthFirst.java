package exercises.search;

public class BinaryDepthFirst<V extends Comparable<V>> {

    private Node<V> root;

    public void add(V v) {
        if (root == null) {
            root = new Node<>(v);
        } else {

            Node<V> currentNode = root;

            while (true) {
                if (v.compareTo(currentNode.value) == -1) {
                    if (currentNode.left == null) {
                        currentNode.left = new Node<>(v);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new Node<>(v);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
        }
    }

    private void preOrder(Node<V> node) {
        System.out.println(node.value);

        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void inOrder() {
        if (root != null) {
            inOrder(root);
        }
    }

    private void inOrder(Node<V> node) {
        if (node.left != null) {
            preOrder(node.left);
        }

        System.out.println(node.value);

        if (node.right != null) {
            preOrder(node.right);
        }
    }

    private void postOrder(Node<V> node) {
        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }

        System.out.println(node.value);
    }

    @Override
    public String toString() {
        return "BinaryDepthFirst{" +
                "root=" + root +
                '}';
    }

    private class Node<V> {

        V       value;
        Node<V> left;
        Node<V> right;

        public Node(V v) {
            this.value = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
