package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void append() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        assertEquals(0, list.getSize());
        list.append("hi");
        assertEquals(1, list.getSize());
        list.append("hi");
        list.append("bye");
        assertEquals(3, list.getSize());
    }

    @Test
    void prepend() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        assertEquals(0, list.getSize());
        list.prepend("hi");
        assertEquals(1, list.getSize());
        list.prepend("hi");
        list.prepend("bye");
        assertEquals(3, list.getSize());
        assertEquals("bye", list.getFirst());
    }

    @Test
    void getSize() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        assertEquals(0, list.getSize());
        list.append("hi");
        assertEquals(1, list.getSize());
        list.append("hi");
        assertEquals(2, list.getSize());
    }

    @Test
    void isEmpty() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        assertTrue(list.isEmpty());
        list.append("hi");
        assertFalse(list.isEmpty());
        list.remove("hi");
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals("hi", list.get(0));
        list.append("bye");
        assertEquals("bye", list.get(1));
        list.append("greets");
        assertEquals("greets", list.get(2));
        assertEquals("hi", list.get(0));
        assertEquals("bye", list.get(1));
    }

    @Test
    void removeByIndex() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals("hi", list.remove(0));
        assertTrue(list.isEmpty());
        list.append("bye");
        list.append("byte");
        assertFalse(list.isEmpty());
        assertEquals("byte", list.remove(1));
        assertEquals("bye", list.remove(0));
        list.append("fight");
        list.append("flight");
        list.append("tight");
        assertEquals("flight", list.remove(1));
        assertEquals("tight", list.remove(1));
        assertEquals("fight", list.remove(0));
    }

    @Test
    void removeByData() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals("hi", list.remove("hi"));
        assertTrue(list.isEmpty());
        list.append("bye");
        list.append("byte");
        assertFalse(list.isEmpty());
        assertEquals("byte", list.remove("byte"));
        assertEquals("bye", list.remove("bye"));
        list.append("fight");
        list.append("flight");
        list.append("tight");
        assertEquals(3, list.getSize());
        assertEquals("flight", list.remove("flight"));
        assertEquals(2, list.getSize());
        assertEquals("tight", list.remove("tight"));
        assertEquals(1, list.getSize());
        assertEquals("fight", list.remove("fight"));
        assertEquals(0, list.getSize());
    }

    @Test
    void indexOf() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals(0, list.indexOf("hi"));
        list.append("bye");
        list.append("byte");
        assertEquals(2, list.indexOf("byte"));
        list.append("fight");
        list.append("flight");
        list.append("tight");
        assertEquals(4, list.indexOf("flight"));
        assertEquals(5, list.indexOf("tight"));
        assertEquals(3, list.indexOf("fight"));
    }

    @Test
    void contains() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertTrue(list.contains("hi"));
        list.append("bye");
        list.append("byte");
        assertTrue(list.contains("byte"));
        list.append("fight");
        list.append("flight");
        list.append("tight");
        assertTrue(list.contains("flight"));
        assertTrue(list.contains("tight"));
        assertTrue(list.contains("fight"));
        assertFalse(list.contains("right"));
        assertFalse(list.contains("kite"));
        assertFalse(list.contains("chi"));
        assertFalse(list.contains(null));
    }


    @Test
    void getFirst() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals("hi", list.getFirst());
        list.append("bye");
        list.append("byte");
        assertEquals("hi", list.getFirst());
        assertEquals("hi", list.remove(0));
        assertEquals("bye", list.getFirst());
    }

    @Test
    void getLast() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.append("hi");
        assertEquals("hi", list.getLast());
        list.append("bye");
        list.append("byte");
        assertEquals("byte", list.getLast());
        assertEquals("byte", list.remove(2));
        assertEquals("bye", list.getLast());
    }

    @Test
    void toStringTest() {
        final MyLinkedList<String> list = new MyLinkedList<>();
        assertEquals("[]", list.toString());
        list.append("a");
        assertEquals("[a]", list.toString());
        list.append("b");
        assertEquals("[a,b]", list.toString());
        list.prepend("c");
        assertEquals("[c,a,b]", list.toString());
    }
}