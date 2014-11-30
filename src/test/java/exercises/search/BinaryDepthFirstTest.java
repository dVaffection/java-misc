package exercises.search;

import org.junit.Before;
import org.junit.Test;

public class BinaryDepthFirstTest {

    BinaryDepthFirst<Integer> binaryDepthFirst;

    @Before
    public void setUp() {
        binaryDepthFirst = new BinaryDepthFirst<>();
        binaryDepthFirst.add(13);
        binaryDepthFirst.add(8);
        binaryDepthFirst.add(1);
        binaryDepthFirst.add(11);
        binaryDepthFirst.add(6);
        binaryDepthFirst.add(17);
        binaryDepthFirst.add(15);
        binaryDepthFirst.add(25);
        binaryDepthFirst.add(22);
    }

    @Test
    public void preOrder() {
        binaryDepthFirst.preOrder();
        System.out.println("---------------------------------------------------------------------------------");
    }

    @Test
    public void inOrder() {
        binaryDepthFirst.inOrder();
        System.out.println("---------------------------------------------------------------------------------");
    }
}