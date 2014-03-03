import java.util.HashMap;
import java.util.LinkedList;

public class CappedStorage<String, V> {

    private int size;
    private LinkedList<String> keys;
    private HashMap<String, V> values;

    CappedStorage(int size) {
        this.size = size;
        keys = new LinkedList<>();
        values = new HashMap<>();
    }

    public V get(String key) throws Exception {
        if (!exists(key)) {
            throw new Exception("Value does not exist");
        }

        return values.get(key);
    }

    public boolean exists(String key) {
        return values.containsKey(key);
    }

    public void remove(String key) {
        keys.remove(key);
        values.remove(key);
    }

    public void add(String key, V value) {
        if (values.containsKey(key)) {
            update(key, value);
        } else {
            insert(key, value);
        }
    }

    private void insert(String key, V value) {
        // once we gonna exceed the given size, let's clear head (dequeue)
        if (keys.size() >= size) {
            String oldestKey = keys.removeFirst();
            values.remove(oldestKey);
        }

        // enqueue
        keys.add(key);
        values.put(key, value);
    }

    private void update(String key, V value) {
        values.put(key, value);

        // refresh key
        keys.remove(key);
        keys.add(key);
    }

}
