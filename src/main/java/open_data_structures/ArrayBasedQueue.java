package open_data_structures;

import java.util.Arrays;

public class ArrayBasedQueue<T> implements Queue<T> {

    private int initSize;
    private int n; // real number of elements in `a` array
    private int j; // index of the next element to remove, e.g. [j + 0], [j + 1],...[j + n]
    private T[] a;

    public ArrayBasedQueue(int initSize) {
        this.initSize = initSize;
        a = (T[]) new Object[initSize];
        n = 0;
        j = 0;
    }

    @Override
    public void enqueue(T o) {
        if (n == a.length) {
            resize();
        }

        int i = (j + n) % a.length;
        a[i] = o;

        n++;
    }

    @Override
    public T dequeue() {
        T o = a[j];
        a[j] = null;

        j = (j + 1) % a.length;
        n--;

        if (n * 3 <= a.length) {
            resize();
        }

        return o;
    }

    private void resize() {
        // make sure size is always greater than zero
        int size = n == 0 ? initSize : n * 2;
        T[] b = (T[]) new Object[size];

        for (int i = 0, k; i < n; i++) {
            k = (i + j) % a.length;
            b[i] = a[k];
        }

        a = b;
        j = 0;
    }

    void printArray() {
        System.out.println(Arrays.toString(a));
    }

}
