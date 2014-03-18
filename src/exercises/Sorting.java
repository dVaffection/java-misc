package exercises;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static <T extends Comparable<? super T>> void bubble(T[] array) {
        for (int i = 0, j = array.length; i < array.length; i++, j--) {
            for (int k = 1; k < j; k++) {
                if (array[k - 1].compareTo(array[k]) > 0) {
                    T tmp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> T[] shuffle(T[] array) {
        T[] copy = Arrays.copyOf(array, array.length);
        Random random = new Random();

        int n = copy.length;
        while (n > 1) {
            int k = random.nextInt(n);
            n--;

            T tmp = copy[n];
            copy[n] = copy[k];
            copy[k] = tmp;


        }

        return copy;
    }

}
