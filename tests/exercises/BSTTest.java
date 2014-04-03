package exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void dump() {
        bst.add(8);
        bst.add(3);
        bst.add(3);
        bst.add(6);
        bst.add(6);
        bst.add(14);
        bst.add(13);
        bst.add(1);
        bst.add(7);
        bst.add(10);
        bst.add(4);
        bst.add(16);
        bst.add(2);

        bst.dump();
    }
}
