package name.khaugsbakk;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Optional;

// Uses chaining
public class HashMap<K, V> implements Dictionary<K, V> {

    private static final int SIZE = 8;

    ArrayList<ArrayListMap<K, V>> map = new ArrayList<>();
    {
        for (int i = 0; i < SIZE; i++) {
            map.add(new ArrayListMap<>());
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
