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

    public static <T extends Comparable<? super T>> void bogo(T[] array) {
        do {
            shuffle(array);
        } while (!isSorted(array));
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] array) {
        if (array.length < 2) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static <T extends Comparable<? super T>> void shuffle(T[] array) {
        if (array.length < 2) {
            return;
        }

        T[] copy = Arrays.copyOf(array, array.length);
        Random random = new Random();

        int n = array.length;
        while (n > 1) {
            int k = random.nextInt(n);
            n--;

            T tmp = array[n];
            array[n] = array[k];
            array[k] = tmp;
        }

        if (Arrays.equals(copy, array)) {
            shuffle(array);
        }
    }

}
