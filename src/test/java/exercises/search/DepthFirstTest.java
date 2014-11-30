package exercises.search;

import org.junit.Test;

public class DepthFirstTest {

    @Test
    public void test() {
        DepthFirst graph = new DepthFirst();
        graph.add("a", "");
        graph.add("b", "a");
        graph.add("c", "a");
        graph.add("d", "b");
        graph.add("e", "b");
        graph.add("h", "e");
        graph.add("f", "c");
        graph.add("g", "c");

        String value = graph.find("h");
        System.out.println("Found: " + value);
        System.out.println("Path must be: a, c, g, f, b, d, e, h");
    }

}