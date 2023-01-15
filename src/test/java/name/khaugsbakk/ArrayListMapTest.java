package name.khaugsbakk;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;

public class ArrayListMapTest {

    @Test
    public void addOne() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        org.junit.jupiter.api.Assertions.assertEquals(dict.get(1).get(), "One");
    }

    public void overwriteOne() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(1, "Uno");
        org.junit.jupiter.api.Assertions.assertEquals(dict.get(1).get(), "Uno");
    }

    public void addTwo() {
        var dict = new ArrayListMap<Integer, String>();
        dict.insert(1, "One");
        dict.insert(2, "Two");
        org.junit.jupiter.api.Assertions.assertEquals(dict.get(1).get(), "One");
        org.junit.jupiter.api.Assertions.assertEquals(dict.get(1).get(), "Two");
    }
}
