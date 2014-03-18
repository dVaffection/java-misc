package exercises;

public class Sorting {

    public static <T extends Comparable<? super T>> T[] bubble(T[] array) {
        for (int i = 0, j = array.length; i < array.length; i++, j--) {
            for (int k = 1; k < j; k++) {
                if (array[k - 1].compareTo(array[k]) > 0) {
                    T tmp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = tmp;
                }
            }
        }

        return array;
    }

}
