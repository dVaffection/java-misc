package maps;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String... args) {
        Map<A, String> map = new TreeMap<>();
        map.put(new A(), "anything");
    }

    public static class A {

    }


}
