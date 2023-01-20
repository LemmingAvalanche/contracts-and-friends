package name.khaugsbakk.v1;

import name.khaugsbakk.v1.ArrayListMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListMapTest {

    @Test
    public void addOne() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        assertEquals(dict.get(1).get(), "One");
    }

    @Test
    public void overwriteOne() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(1, "Uno");
        assertEquals(dict.get(1).get(), "Uno");
    }

    @Test
    public void addTwo() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(2, "Two");
        assertEquals(dict.get(1).get(), "One");
        assertEquals(dict.get(2).get(), "Two");
    }

    @Test
    public void sixHundredInsertsAndSizeSixHundred() {
        var dict = new ArrayListMap<Integer, String>();
        for (int i = 0; i < 600; i++) {
            dict.insert(i, "" + i);
        }
        assertEquals(600, dict.size());
    }
}
