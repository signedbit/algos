package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHeapTest {

    @Test
    void insert() {
        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 0; i < 34; i++) {
                heap.insert(i);
                assertEquals(Integer.valueOf(0), heap.peek_min());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
            }
        }
    }

    @Test
    void peek_min() {
        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 5; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
            }
            for (int i = 0; i < 6; i++) {
                final int min = heap.peek_min();
                assertEquals(i, min);
                assertEquals(Integer.valueOf(min), heap.extract_min());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
            }
            for (int i = 0; i < 34; i++) {
                int min = heap.peek_min();
                assertEquals(i, min);
                min = heap.extract_min();
                assertEquals(i, min);
                min = heap.peek_min();
                assertEquals(i, min);
                min = heap.extract_min();
                assertEquals(i, min);
            }
        }
    }

    @Test
    void extract_min() {

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peek_min());
            }
            for (int i = 0; i < 34; i++) {
                final int min = heap.extract_min();
                assertEquals(i, min);
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                heap.insert(i);
            }
            for (int i = 0; i < 34; i++) {
                int min = heap.extract_min();
                assertEquals(i, min);
                min = heap.extract_min();
                assertEquals(i, min);
            }
        }
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }
}