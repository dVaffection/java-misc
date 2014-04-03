package exercises;

import java.lang.*;
import java.util.*;

public class BST<E extends Comparable<E>> {

    private Node root;

    class Node {
        Node(E value) {
            this.value = value;
        }

        public Node left;
        public Node right;
        public E    value;
    }

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

}
