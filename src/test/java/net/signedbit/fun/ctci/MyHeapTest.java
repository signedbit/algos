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
                assertEquals(Integer.valueOf(0), heap.peekMinimum());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
            }
        }
    }

    @Test
    void peek_min() {
        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 5; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
            }
            for (int i = 0; i < 6; i++) {
                final int min = heap.peekMinimum();
                assertEquals(i, min);
                assertEquals(Integer.valueOf(min), heap.removeMinimum());
            }
        }

        {
            final MyHeap<Integer> heap = new MyHeap<>();
            for (int i = 33; i >= 0; i--) {
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
                heap.insert(i);
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
            }
            for (int i = 0; i < 34; i++) {
                int min = heap.peekMinimum();
                assertEquals(i, min);
                min = heap.removeMinimum();
                assertEquals(i, min);
                min = heap.peekMinimum();
                assertEquals(i, min);
                min = heap.removeMinimum();
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
                assertEquals(Integer.valueOf(i), heap.peekMinimum());
            }
            for (int i = 0; i < 34; i++) {
                final int min = heap.removeMinimum();
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
                int min = heap.removeMinimum();
                assertEquals(i, min);
                min = heap.removeMinimum();
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