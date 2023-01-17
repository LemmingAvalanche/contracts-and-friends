package name.khaugsbakk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {

    // First four tests copied from `ArrayListMapTest`

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

    @Test
    public void sixHundredInsertsAndSizeSixHundred() {
        var dict = new HashMap<>();
        for (int i = 0; i < 600; i++) {
            dict.insert(i, "" + i);
        }
        assertEquals(600, dict.size());
    }

    // End: First four tests copied from `ArrayListMapTest`

}
