package io.github.alexengrig.nih.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {
    @Test
    public void should_create_newArray_by_length() {
        final int length = 10;
        final Array<Object> array = new Array<>(length);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
    }

    @Test
    public void should_create_newArray_by_values() {
        final Object[] expected = new Object[]{1, 2, 3};
        final int length = expected.length;
        final Array<Object> array = new Array<>(expected);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_create_newArray_by_varargs() {
        final Object[] expected = new Object[]{1, 2, 3};
        final int length = expected.length;
        final Array<Object> array = new Array<>(expected[0], expected[1], expected[2]);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_value_to_array() {
        final int length = 1;
        final Array<Object> array = new Array<>(length);
        array.add(new Object());
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_values_to_array() {
        final Object[] values = new Object[]{new Object(), new Object()};
        final int length = values.length;
        final Array<Object> array = new Array<>(length);
        array.addAll(values);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_return_value_by_index_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(new Object(), expected);
        assertEquals("Element at index 1", expected, array.get(1));
    }

    @Test
    public void should_return_firstValue_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected, new Object());
        assertEquals("First element", expected, array.getFirst());
    }

    @Test
    public void should_return_lastValue_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(new Object(), expected);
        assertEquals("Last element", expected, array.getLast());
    }

    @Test
    public void should_remove_value_from_singletonArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.remove(0);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_value_from_doubleArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected, new Object());
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 2, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.remove(0);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 1, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_firstValue_from_singletonArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeFirst();
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_firstValue_from_doubleArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected, new Object());
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 2, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeFirst();
        assertEquals("Begin", 1, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_lastValue_from_singletonArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeLast();
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_lastValue_from_doubleArray() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(new Object(), expected);
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 0, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 2, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeLast();
        assertEquals("Begin", 0, array.begin);
        assertEquals("End", 1, array.end);
        assertEquals("Array length", 2, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }
}