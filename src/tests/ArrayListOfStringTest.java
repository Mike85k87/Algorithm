package tests;

import service.ArrayListOfString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class ArrayListOfStringTest {
    private ArrayListOfString list;

    @Before
    public void setUp() {
        list = new ArrayListOfString();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
    }

    @Test
    public void testAdd() {
        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Cherry", list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        list.add(1, "Grape");
        assertEquals("Grape", list.get(1));
        assertEquals("Banana", list.get(2));
    }

    @Test
    public void testSet() {
        assertEquals("Banana", list.set(1, "Grape"));
        assertEquals("Grape", list.get(1));
    }

    @Test
    public void testRemove() {
        assertEquals("Banana", list.remove("Banana"));
        assertFalse(list.contains("Banana"));
    }

    @Test
    public void testRemoveAtIndex() {
        assertEquals("Banana", list.remove(1));
        assertFalse(list.contains("Banana"));
    }

    @Test
    public void testContains() {
        assertTrue(list.contains("Apple"));
        assertFalse(list.contains("Orange"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf("Apple"));
        assertEquals(-1, list.indexOf("Orange"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("Apple"); // Adding another "Apple"
        assertEquals(3, list.lastIndexOf("Apple"));
        assertEquals(-1, list.lastIndexOf("Orange"));
    }

    @Test
    public void testGet() {
        assertEquals("Cherry", list.get(2));
    }

    @Test
    public void testEquals() {
        ArrayListOfString otherList = new ArrayListOfString();
        otherList.add("Apple");
        otherList.add("Banana");
        otherList.add("Cherry");
        assertTrue(list.equals(otherList));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
        list.remove("Banana");
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        String[] array = list.toArray();
        assertArrayEquals(new String[]{"Apple", "Banana", "Cherry"}, array);
    }
}
