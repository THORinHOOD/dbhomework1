package com.homework1;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedSuperIntegerListTest {

    @Test
    public void addElementsAndGetThem() {
        SuperIntegerList list = new LinkedSuperIntegerList();
        list.add(5);
        list.add(6);
        list.add(1);
        assertEquals(5, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void removeElementByIndex() {
        SuperIntegerList list = new LinkedSuperIntegerList();
        list.add(9);
        list.add(1);
        list.add(12);
        list.add(5);
        list.removeByIndex(2);
        assertEquals(9, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(5, list.get(2));
        list.removeByIndex(0);
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        list.removeByIndex(1);
        assertEquals(1, list.get(0));
        list.removeByIndex(0);
        list.add(8);
        assertEquals(8, list.get(0));
        list.add(10);
        assertEquals(8, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    public void removeElementByValue() {
        SuperIntegerList list = new LinkedSuperIntegerList();
        list.add(9);
        list.add(1);
        list.add(12);
        list.add(5);
        list.removeByValue(10);
        assertEquals(9, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(12, list.get(2));
        assertEquals(5, list.get(3));
        list.removeByValue(1);
        assertEquals(9, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(5, list.get(2));
        list.removeByValue(9);
        assertEquals(12, list.get(0));
        assertEquals(5, list.get(1));
        list.removeByValue(5);
        assertEquals(12, list.get(0));
        list.removeByValue(12);
        list.add(5);
        assertEquals(5, list.get(0));
    }

    @Test
    public void throwIndexOutOfRangeException() {
        SuperIntegerList list = new LinkedSuperIntegerList();
        list.add(5);
        list.add(6);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
        list.removeByIndex(0);
        list.removeByIndex(0);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

}