package name.khaugsbakk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {

    // First three tests copied from `ArrayListMapTest`

    @Test
    public void addOne() {
        var dict = new HashMap<>();
        dict.insert(1, "One");
        assertEquals(dict.get(1).get(), "One");
    }

    @Test
    public void overwriteOne() {
        var dict = new HashMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(1, "Uno");
        assertEquals(dict.get(1).get(), "Uno");
    }

    @Test
    public void addTwo() {
        var dict = new HashMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(2, "Two");
        assertEquals(dict.get(1).get(), "One");
        assertEquals(dict.get(2).get(), "Two");
    }

    // End: First three tests copied from `ArrayListMapTest`

}
