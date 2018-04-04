package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private <T> MyQueue<T> getStack() {
        return new MyQueue<>();
    }

    @Test
    void push() {
        final MyQueue<Integer> queue = getStack();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.push(2);
        assertEquals(2, queue.getHeight());
        queue.push(3);
        assertEquals(3, queue.getHeight());
    }

    @Test
    void pop() {
        final MyQueue<Integer> queue = getStack();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.push(2);
        assertEquals(Integer.valueOf(1), queue.pop());
        queue.push(3);
        assertEquals(Integer.valueOf(2), queue.pop());
    }

    @Test
    void peek() {
        final MyQueue<Integer> queue = getStack();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.push(2);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.push(3);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.pop();
        assertEquals(Integer.valueOf(2), queue.peek());
    }

    @Test
    void isEmpty() {
        final MyQueue<Integer> queue = getStack();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.push(2);
        assertFalse(queue.isEmpty());
        queue.pop();
        assertFalse(queue.isEmpty());
        queue.pop();
        assertTrue(queue.isEmpty());
        queue.push(3);
        assertFalse(queue.isEmpty());
        queue.pop();
        assertTrue(queue.isEmpty());
    }


    @Test
    void getHeight() {
        final MyQueue<Integer> queue = getStack();
        assertEquals(0, queue.getHeight());
        queue.push(1);
        assertEquals(1, queue.getHeight());
        queue.push(2);
        assertEquals(2, queue.getHeight());
        queue.pop();
        assertEquals(1, queue.getHeight());
        queue.pop();
        assertEquals(0, queue.getHeight());
        queue.push(3);
        assertEquals(1, queue.getHeight());
        queue.pop();
        assertEquals(0, queue.getHeight());
    }
}