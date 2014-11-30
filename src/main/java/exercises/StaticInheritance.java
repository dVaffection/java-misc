package exercises;

public class StaticInheritance {

    public static void main(String... args) {
        Chrysler.model();
    }

    static class Car {

        protected static String model = "Car";

        public static void model() {
            System.out.println(model);
        }

    }

    static class Chrysler extends Car {

//        protected static String model = "Chrysler";

        public static void model() {
            System.out.println("as");
        }
    }

}
