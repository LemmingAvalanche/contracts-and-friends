package name.khaugsbakk;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Optional;

public class ArrayListMap<K, V> implements Dictionary<K, V> {

    private final ArrayList<Pair<K, V>> list = new ArrayList<>();

    @Override
    public void insert(K key, V value) {
        int preSize = list.size();

        int index = indexOf(key);
        if (index > -1) {
            list.set(index, Pair.of(key, value));
        } else {
            list.add(Pair.of(key, value));
        }
        assert list.size() >= preSize;
        assert get(key).isPresent();
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

    private int indexOf(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (key.equals(list.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }

}
