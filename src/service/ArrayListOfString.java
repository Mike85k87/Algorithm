package service;

import java.util.Arrays;

public class ArrayListOfString implements StringList {
    public ArrayListOfString(String[] array, int size) {
        this.array = array;
        this.size = size;
    }

    private static final int INITIAL_CAPACITY = 10;
    private String[] array;
    private int size;

    public ArrayListOfString() {
        this.array = new String[INITIAL_CAPACITY];
        this.size = 0;
    }
    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item cannot be added.");
        }
        ensureCapacity(size + 1);
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Null item cannot be added.");
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Null item cannot be set.");
        }
        String oldValue = array[index];
        array[index] = item;
        return oldValue;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item cannot be removed.");
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Item not found in the list.");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        String removedItem = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null; // Clear the reference to the last element
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null.");
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    @Override
    public String[] toArray() {

        return Arrays.copyOf(array, size);
    }

    // метод для обеспечения емкости внутреннего массива
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
