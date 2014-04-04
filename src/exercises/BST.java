package exercises;

import java.util.*;

public class BST<E extends Comparable<E>> {

    private Node root;

    public boolean add(E e) {
        if (root == null) {
            root = new Node(e);
            return true;
        } else {
            return addDeep(root, e);
        }
    }

    private boolean addDeep(Node node, E e) {
        if (node.value == e) {
            // duplicate node
            return false;
        } else if (e.compareTo(node.value) == -1) {
            if (node.left == null) {
                node.left = new Node(e);
                return true;
            } else {
                return addDeep(node.left, e);
            }
        } else if (e.compareTo(node.value) == 1) {
            if (node.right == null) {
                node.right = new Node(e);
                return true;
            } else {
                return addDeep(node.right, e);
            }
        }

        return false;
    }

    public boolean delete(E e) {
        return delete(e, root, null);
    }

    private boolean delete(E e, Node cur, Node prev) {
        if (cur != null) {
            if (cur.value == e) {
                if (cur.left == null && cur.right == null) {
                    // node has no children (leaf), simply delete it
                    if (prev.left == cur) {
                        prev.left = null;
                    } else if (prev.right == null) {
                        prev.right = null;
                    } else {
                        throw new RuntimeException("Node " + cur.value + " was not found at its predecessor " + prev.value);
                    }
                } else if (cur.left != null && cur.right == null) {
                    // current node becomes its left child
                    cur = cur.left;
                } else if (cur.right != null && cur.left == null) {
                    // current node becomes its right child
                    cur = cur.right;
                } else {
                    // current node has both left and right children
                    throw new RuntimeException("Can not delete node with both children");
                }

                return true;
            } else {
                boolean is;
                is = delete(e, cur.left, cur);
                if (!is) {
                    is = delete(e, cur.right, cur);
                }
                return is;
            }
        }

        return false;
    }

    public void dump() {
        LinkedHashMap<Integer, List<E>> valuesByLevels = new LinkedHashMap<>();
        collectValuesByLevels(root, 1, valuesByLevels);

        for (Map.Entry<Integer, List<E>> mapEntry : valuesByLevels.entrySet()) {
            System.out.print("Level " + mapEntry.getKey() + ": ");
            System.out.println(mapEntry.getValue());
        }
    }

    private void collectValuesByLevels(Node node, int currentLevel, Map<Integer, List<E>> valuesByLevels) {
        if (node == null) {
            return;
        } else {
            List<E> values = valuesByLevels.get(currentLevel);
            if (!(values instanceof List)) {
                values = new LinkedList<>();
            }
            values.add(node.value);
            valuesByLevels.put(currentLevel, values);

            int leftLevel = currentLevel + 1;
            int rightLevel = currentLevel + 1;
            collectValuesByLevels(node.left, leftLevel, valuesByLevels);
            collectValuesByLevels(node.right, rightLevel, valuesByLevels);
        }
    }

    public List<E> traversePreOrder() {
        List<E> path = new LinkedList<>();

        traversePreOrder(root, path);
        return path;
    }

    private void traversePreOrder(Node node, List<E> path) {
        if (node != null) {
            path.add(node.value);

            traversePreOrder(node.left, path);
            traversePreOrder(node.right, path);
        }
    }

    public List<E> traverseInOrder() {
        List<E> path = new LinkedList<>();

        traverseInOrder(root, path);
        return path;
    }

    private void traverseInOrder(Node node, List<E> path) {
        if (node != null) {
            traverseInOrder(node.left, path);

            path.add(node.value);

            traverseInOrder(node.right, path);
        }
    }

    public List<E> traversePostOrder() {
        List<E> path = new LinkedList<>();

        traversePostOrder(root, path);
        return path;
    }

    private void traversePostOrder(Node node, List<E> path) {
        if (node != null) {
            traversePostOrder(node.left, path);
            traversePostOrder(node.right, path);

            path.add(node.value);
        }
    }

    class Node {

        public Node left;
        public Node right;
        public E    value;

        Node(E value) {
            this.value = value;
        }
    }

}
