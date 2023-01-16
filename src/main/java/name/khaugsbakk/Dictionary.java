package name.khaugsbakk;

import java.util.Optional;

public interface Dictionary<K, V> {

    Optional<V> get(K key);
    void insert(K key, V value);
    int size();
}
