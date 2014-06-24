package exercises;


import java.util.ArrayList;

public class Cloning {

    static class Item {
        private String name;

        public Item(String name) {
            setName(name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String... str) {
        Item ring = new Item("Silver ring");

        ArrayList<Item> items1 = new ArrayList<>();
        items1.add(ring);

        ArrayList<Item> items2 = (ArrayList<Item>) items1.clone();

        items1.get(0).setName("Golden ring");

        printIterable(items1);
        printIterable(items2);
    }

    private static void printIterable(Iterable iterable) {
        for (Object item: iterable) {
            System.out.print(item);
            System.out.print(" ");
        }

        System.out.println(" ");
    }

}
