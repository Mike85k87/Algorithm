package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ArrayListOfInteger;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ArrayListOfStringTest {
    private ArrayListOfInteger list;

    @Before
    public void setUp() {
        list = new ArrayListOfInteger();
        list.add(0);
        list.add(1);
        list.add(2);
    }

    @Test
    public void testAdd() {
        assertEquals(Optional.of(0), list.add(0));
        assertEquals(22, Optional.ofNullable(list.get(1)));
        assertEquals(33, Optional.ofNullable(list.get(2)));
    }

    @Test
    public void testAddAtIndex() {
        assertEquals(Optional.of(11), list.get(0));
        assertEquals("22", list.get(1));
        assertEquals("33", list.get(2));
    }

    @Test
    public void testSet() {
        assertEquals("22", list.set(1,1));
        assertEquals("33", list.get(1));
    }

    @Test
    public void testRemove() {
        assertEquals("22", list.remove(33));
        Assert.assertFalse(list.contains(44));
    }

    @Test
    public void testRemoveAtIndex() {
        assertEquals("22", list.remove(1));
        Assert.assertFalse(list.contains(33));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains(22));
        Assert.assertFalse(list.contains(33));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(11));
        assertEquals(-1, list.indexOf(33));
    }

    @Test
    public void testLastIndexOf() {
        list.add(12); // Adding another "Apple"
        assertEquals(3, list.lastIndexOf(12));
        assertEquals(-1, list.lastIndexOf(13));
    }

    @Test
    public void testGet() {
        assertEquals("33", list.get(2));
    }

    @Test
    public void testEquals() {
        ArrayListOfInteger otherList = new ArrayListOfInteger();
        otherList.add(11);
        otherList.add(22);
        otherList.add(33);
        Assert.assertTrue(list.equals(otherList));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
        list.remove(33);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(list.isEmpty());
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        Integer[] array = list.toArray();
        Assert.assertArrayEquals(new Integer[]{11, 22, 33}, array);
    }
}