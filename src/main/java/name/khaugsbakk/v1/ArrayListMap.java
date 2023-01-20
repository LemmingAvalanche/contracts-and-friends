package name.khaugsbakk.v1;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class ArrayListMap<K, V> implements Dictionary<K, V>, Iterable<Pair<K, V>> {

    private final ArrayList<Pair<K, V>> list = new ArrayList<>();

    @Override
    public boolean insert(K key, V value) {
        int preSize = list.size();

        int index = indexOf(key);
        boolean existed = false;
        if (index != -1) {
            list.set(index, Pair.of(key, value));
            existed = true;
        } else {
            list.add(Pair.of(key, value));
        }
        assert list.size() >= preSize;
        assert get(key).get().equals(value);
        return existed;
    }

    @Override
    public Optional<V> get(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return Optional.of(list.get(index).getValue());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    private int indexOf(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (key.equals(list.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return list.iterator();
    }
}
