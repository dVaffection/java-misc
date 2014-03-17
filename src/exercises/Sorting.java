package exercises;

public class Sorting {

    public int[] bubble(int[] array) {
        for (int run = 0, length = array.length; run < array.length; run++, length--) {
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }

}
