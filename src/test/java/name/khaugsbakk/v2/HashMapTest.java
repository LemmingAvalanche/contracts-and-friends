package name.khaugsbakk.v2;

import name.khaugsbakk.v2.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HashMapTest {

    // First six tests copied from `ArrayListMapTest`

    public void addOne() {
        var dict = new HashMap<Integer, String>();
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
    public void addTwoAndRemove() {
        var dict = new HashMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(2, "Two");
        dict.remove(1);
        dict.remove(2);
        assertFalse(dict.insert(1, "One"));
        assertFalse(dict.insert(2, "Two"));
    }

    @Test
    public void sixHundredInsertsAndSizeSixHundred() {
        var dict = new HashMap<Integer, String>();
        for (int i = 0; i < 600; i++) {
            dict.insert(i, "" + i);
        }
        assertEquals(600, dict.size());
    }

    @Test
    public void sixHundredComeAndGo() {
        var dict = new HashMap<>();
        for (int i = 0; i < 600; i++) {
            dict.insert(i, "" + i);
        }
        for (int i = 0; i < 600; i++) {
            dict.remove(i);
        }
        assertEquals(0, dict.size());
    }

    // End: First six tests copied from `ArrayListMapTest`

}
