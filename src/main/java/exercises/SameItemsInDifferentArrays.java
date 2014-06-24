package exercises;

public class SameItemsInDifferentArrays {

    /**
     * Find the number of the same items in 3 separate arrays
     */
    public static <V> int straightForward(V[] arr1, V[] arr2, V[] arr3) {
        int same = 0;

        if (arr1.length > arr2.length && arr1.length > arr3.length) {
            same = straightForwardArgsOrdered(arr1, arr2, arr3);
        } else if (arr2.length > arr1.length && arr2.length > arr3.length) {
            same = straightForwardArgsOrdered(arr2, arr1, arr3);
        } else {
            same = straightForwardArgsOrdered(arr3, arr2, arr1);
        }

        return same;
    }

    /**
     * First argument is the longest array with
     */
    private static <V> int straightForwardArgsOrdered(V[] arr1, V[] arr2, V[] arr3) {
        int same = 0;

        for (int i = 0; i < arr1.length; i++) {
            V arr1Value = arr1[i];

            for (int j = 0; j < arr2.length; j++) {
                V arr2Value = arr2[j];

                for (int k = 0; k < arr3.length; k++) {
                    V arr3Value = arr3[k];

                    if (arr1Value.equals(arr2Value) && arr1Value.equals(arr3Value)) {
                        same++;
                        break;
                    }
                }
            }
        }

        return same;
    }

}
