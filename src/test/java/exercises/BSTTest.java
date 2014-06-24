package exercises;

import org.junit.*;

import java.util.*;

public class BSTTest {

    BST<Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void add() {
        Assert.assertTrue(bst.add(8));
        Assert.assertTrue(bst.add(3));
        Assert.assertFalse(bst.add(3));
        Assert.assertTrue(bst.add(6));
        Assert.assertFalse(bst.add(6));
    }

    private List<Integer> getValues() {
        return Arrays.asList(8, 3, 3, 6, 6, 10, 14, 1, 7, 13, 4);
    }

    @Test
    public void dump() {
        List<Integer> values = getValues();

        for (Integer value : values) {
            bst.add(value);
        }

        bst.dump();
    }

    @Test
    public void delete() {
        List<Integer> values = getValues();

        for (Integer value : values) {
            bst.add(value);
        }

        bst.delete(1);
        bst.dump();
    }

    @Test
    public void traversePreOrder() {
        List<Integer> values = getValues();

        for (Integer value : values) {
            bst.add(value);
        }

        List<Integer> expected = Arrays.asList(8, 3, 1, 6, 4, 7, 10, 14, 13);
        List<Integer> path = bst.traversePreOrder();
        Assert.assertEquals(expected, path);

//        System.out.println("Pre-order: " + path);
    }

    @Test
    public void traverseInOrder() {
        List<Integer> values = getValues();

        for (Integer value : values) {
            bst.add(value);
        }

        List<Integer> expected = Arrays.asList(1, 3, 4, 6, 7, 8, 10, 13, 14);
        List<Integer> path = bst.traverseInOrder();
        Assert.assertEquals(expected, path);

//        System.out.println("In-order: " + path);
    }

    @Test
    public void traversePostOrder() {
        List<Integer> values = getValues();

        for (Integer value : values) {
            bst.add(value);
        }

        List<Integer> expected = Arrays.asList(1, 4, 7, 6, 3, 13, 14, 10, 8);
        List<Integer> path = bst.traversePostOrder();
        Assert.assertEquals(expected, path);

//        System.out.println("Post-order: " + path);
    }
}
