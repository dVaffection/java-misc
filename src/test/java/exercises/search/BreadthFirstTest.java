package exercises.search;

import org.junit.Test;

public class BreadthFirstTest {

    @Test
    public void test() {
        BreadthFirst graph = new BreadthFirst();
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
        System.out.println("Path must be: a, b, c, d, e, f, g, h");
    }
}