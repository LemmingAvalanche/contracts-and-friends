package name.khaugsbakk;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Optional;

// Uses chaining
public class HashMap<K, V> implements Dictionary<K, V> {

    private static final int SIZE = 8;

    private static final float loadFactor = 0.7f;

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
        for (int i = 0; i < newCapacity; i++) {
            newMap.add(new ArrayListMap<>());
        }
        for (var subMap : oldMap) {
            for (var pair : subMap) {
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
    public void insert(K key, V value) {
        if (((float) size()) / ((float) map.size()) > loadFactor) {
            resize();
        }
        int preSize = size();

        int hash = key.hashCode();
        int index = hash % map.size();
        map.get(index).insert(key, value);

        assert size() >= preSize;
        assert get(key).get().equals(value);
    }

    @Override
    public int size() {
        int size = 0;
        for (var subMap : map) {
            size += subMap.size();
        }
        return size;
    }
}
