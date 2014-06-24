import java.util.HashMap;
import java.util.LinkedList;

public class CappedStorage<K, V> {

    private int size;
    private LinkedList<K> keys;
    private HashMap<K, V> values;

    CappedStorage(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        this.size = size;
        keys = new LinkedList<>();
        values = new HashMap<>();
    }

    public V get(K key) throws Exception {
        if (!exists(key)) {
            throw new Exception("Value does not exist");
        }

        return values.get(key);
    }

    public boolean exists(K key) {
        return values.containsKey(key);
    }

    public void remove(K key) {
        keys.remove(key);
        values.remove(key);
    }

    public void add(K key, V value) {
        if (values.containsKey(key)) {
            update(key, value);
        } else {
            insert(key, value);
        }
    }

    private void insert(K key, V value) {
        // once we gonna exceed the given size, let's clear head (dequeue)
        if (keys.size() >= size) {
            K oldestKey = keys.removeFirst();
            values.remove(oldestKey);
        }

        // enqueue
        keys.add(key);
        values.put(key, value);
    }

    private void update(K key, V value) {
        values.put(key, value);

        // refresh key
        keys.remove(key);
        keys.add(key);
    }

}
