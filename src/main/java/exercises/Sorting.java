package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Sorting {

    public static void quick(int[] array) {
        if (array.length > 1) {
            quick(array, 0, array.length - 1);
        }
    }

    private static void quick(int[] array, int left, int right) {
        if (left < right) {

            int partition = partition(array, left, right);

            quick(array, 0, partition - 1);
            quick(array, partition + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        // pivot doesn't influence on the algorithm correctness, only on effectiveness
        int pivot = array[(right - left) / 2 + left];

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                swap(array, left, right);

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static <E extends Comparable<E>> List<E> mergeSort(List<E> m) {
        if (m.size() <= 1) return m;

        int middle = m.size() / 2;
        List<E> left = m.subList(0, middle);
        List<E> right = m.subList(middle, m.size());

        right = mergeSort(right);
        left = mergeSort(left);
        List<E> result = merge(left, right);

        return result;
    }

    public static <E extends Comparable<E>> List<E> merge(List<E> left, List<E> right) {
        List<E> result = new ArrayList<E>();
        Iterator<E> it1 = left.iterator();
        Iterator<E> it2 = right.iterator();

        E x = it1.next();
        E y = it2.next();
        while (true) {
            //change the direction of this comparison to change the direction of the sort
            if (x.compareTo(y) <= 0) {
                result.add(x);
                if (it1.hasNext()) {
                    x = it1.next();
                } else {
                    result.add(y);
                    while (it2.hasNext()) {
                        result.add(it2.next());
                    }
                    break;
                }
            } else {
                result.add(y);
                if (it2.hasNext()) {
                    y = it2.next();
                } else {
                    result.add(x);
                    while (it1.hasNext()) {
                        result.add(it1.next());
                    }
                    break;
                }
            }
        }
        return result;
    }

//    public static int[] merge(int[] array) {
//        if (array.length <= 1) {
//            return array;
//        }
//
//        int[] result;
//
//        int middle = array.length / 2;
//        int[] left = Arrays.copyOfRange(array, 0, middle);
//        int[] right = Arrays.copyOfRange(array, middle, array.length);
//
//        merge(left);
//        merge(right);
//
//        result = merge(left, right);
//        return result;
//    }
//
//    private static int[] merge(int[] left, int[] right) {
//        int[] result = new int[left.length + right.length];
//
//        int r = 0;
//        while (left.length > 0 || right.length > 0) {
//            if (left.length > 0 && right.length > 0) {
//                if (left[0] < right[0]) {
//                    result[r] = left[0];
//                    r++;
//                    left = Arrays.copyOfRange(left, 1, left.length);
//                } else {
//                    result[r] = right[0];
//                    r++;
//                    right = Arrays.copyOfRange(right, 1, right.length);
//                }
//            } else if (left.length > 0) {
//                result[r] = left[0];
//                r++;
//                left = Arrays.copyOfRange(left, 1, left.length);
//            } else if (right.length > 0) {
//                result[r] = right[0];
//                r++;
//                right = Arrays.copyOfRange(right, 1, right.length);
//            }
//        }
//
//        System.out.println(Arrays.toString(result));
//
//        return result;
//    }

    public static String recursive(int number) {
        if (number > 0) {
            return recursive(--number);
        } else {
            return "A";
        }
    }

    public static void bubble(int[] array) {
        for (int i = 0, j = array.length; i < array.length; i++, j--) {
            for (int k = 1; k < j; k++) {
                if (array[k - 1] > array[k]) {
                    int tmp = array[k - 1];
                    array[k - 1] = array[k];
                    array[k] = tmp;
                }
            }
        }
    }

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
