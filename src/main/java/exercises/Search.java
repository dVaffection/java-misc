package exercises;

public class Search {

    public static <T extends Comparable<T>> int binary(T[] array, T value) {
        if (array.length < 1) {
            String message = "Array must contain at least one element";
            throw new IllegalArgumentException(message);
        }

        if (array.length <= 2) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(value)) {
                    return i;
                }
            }
            return -1;
        } else {
            int startIndex = 0;
            int endIndex = array.length - 1;
            return binaryRecursive(array, value, startIndex, endIndex);
        }
    }

    private static <T extends Comparable<T>> int binaryRecursive(T[] array, T value, int startIndex, int endIndex) {
        int middleIndex = ((int) Math.floor((endIndex - startIndex) / 2)) + startIndex;
//        System.out.print(startIndex + " ");
//        System.out.print(endIndex + " ");
//        System.out.println(middleIndex);

        if (array[middleIndex].compareTo(value) == 0) {
            return middleIndex;
            // NOTICE: if array is not (properly) sorted we can trap into situation
            // when we loop using 2 index values which differ just in one step from each other
        } else if (array[middleIndex - 1].compareTo(value) == -1 && endIndex - startIndex > 1) {
            return binaryRecursive(array, value, middleIndex, endIndex);
        } else if (array[middleIndex + 1].compareTo(value) == 1 && endIndex - startIndex > 1) {
            return binaryRecursive(array, value, startIndex, middleIndex);
        } else {
            String message = "Given array is not sorted";
            throw new IllegalArgumentException(message);
        }
    }

}
