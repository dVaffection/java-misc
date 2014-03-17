import java.util.LinkedHashMap;

public class LRUCache<K, V> {

    private int size;
    private LinkedHashMap<K, V> cache;

    LRUCache(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        this.size = size;
        cache = new LinkedHashMap<>(size);
    }

    public boolean exists(K key) {
        return cache.containsKey(key);
    }

    public V get(K key) throws Exception {
        if (!cache.containsKey(key)) {
            throw new Exception("Value does not exist by given key: " + key.toString());
        }

        V value = cache.get(key);

        // pop it to the top
        cache.remove(key);
        add(key, value);

        return value;
    }

    public boolean remove(K key) {
        V value = cache.remove(key);
        return value != null;
    }

    public void add(K key, V value) {
        if (cache.size() >= size) {
            // once we approach size limit, let's clear head
            Object[] keys = cache.keySet().toArray();
            cache.remove(keys[0]);
        }

        cache.put(key, value);
    }

}
