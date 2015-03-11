package open_data_structures;

import java.util.Arrays;

public class ArrayBasedList<T> {

    private int n; // real number of elements in `a` array
    private T[] a;

    @SuppressWarnings("unchecked")
    public ArrayBasedList(int initSize) {
        a = (T[]) new Object[initSize];
        n = 0;
    }

    public void add(T o) {
        add(o, n);
    }

    public void add(T o, int i) {
        // grow if no room left
        if (n >= a.length) {
            resize();
        }

        for (int j = a.length - 1; j > i; j--) {
            a[j] = a[j - 1];
        }

        a[i] = o;
        n++;
    }

    public T get(int i) {
        return a[i];
    }

    public void set(T o, int i) {
        a[i] = o;
    }

    public T remove(int i) {
        T o = a[i];

        for (int j = i; j < a.length - 1; j++) {
            a[j] = a[j + 1];
        }

        n--;

        // shrink if number of elements 3 times less than array length
        if (n <= a.length / 3) {
            resize();
        }

        return o;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] b = (T[]) new Object[n * 2];

        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }

        a = b;
    }

    int getArraySize() {
        return a.length;
    }

    int getElementsNumber() {
        return n;
    }

    void printArray() {
        System.out.println(Arrays.toString(a));
    }

}
