package name.khaugsbakk.v2;

import java.util.Optional;

public interface Dictionary<K, V> {

    Optional<V> get(K key);
    /** @return true if the key already existed in the Dictionary */
    boolean insert(K key, V value);
    /**@return true if the key was removed */
    boolean remove(K key);
    int size();
}
