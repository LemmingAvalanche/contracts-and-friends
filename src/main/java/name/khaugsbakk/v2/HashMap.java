package name.khaugsbakk.v2;

import java.util.ArrayList;
import java.util.Optional;

// Uses chaining
public class HashMap<K, V> implements Dictionary<K, V> {

    private static final int SIZE = 8;

    private static final float loadFactor = 0.7f;

    private int size = 0;

    ArrayList<ArrayListMap<K, V>> map = new ArrayList<>();
    {
        for (int i = 0; i < SIZE; i++) {
            map.add(new ArrayListMap<>());
        }
    }

    private void resize() {
        var oldMap = map;
        int newCapacity = map.size() * 2;
        var newMap = new ArrayList<ArrayListMap<K, V>>(newCapacity);
        this.map = newMap;
        size = 0;
        for (int i = 0; i < newCapacity; i++) {
            newMap.add(new ArrayListMap<>());
        }
        for (var bucket : oldMap) {
            for (var pair : bucket) {
                insert(pair.getKey(), pair.getValue());
            }
        }
    }

    @Override
    public Optional<V> get(K key) {
        int hash = key.hashCode();
        int index = hash % map.size();
        return map.get(index).get(key);
    }

    @Override
    public boolean insert(K key, V value) {
        if (((float) size) / ((float) map.size()) > loadFactor) {
            resize();
        }
        int preSize = size;

        int hash = key.hashCode();
        int index = hash % map.size();
        boolean existed = map.get(index).insert(key, value);
        if (!existed) {
            updateSize(size + 1);
        }

        assert size >= preSize;
        assert get(key).get().equals(value);
        return existed;
    }

    @Override
    public boolean remove(K key) {
        int preSize = size;

        int hash = key.hashCode();
        int index = hash % map.size();
        boolean existed = map.get(index).remove(key);
        if (existed) {
            updateSize(size - 1);
        }

        assert size <= preSize;
        assert get(key).isEmpty();
        return existed;
    }

    @Override
    public int size() {
        return size;
    }

    private void updateSize(int s) {
        this.size = s;
        assert s == expensiveSize();
    }

    private int expensiveSize() {
        int size = 0;
        for (var bucket : map) {
            size += bucket.size();
        }
        return size;
    }
}
