package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private <T> IStack<T> getStack() {
        return new SetOfStacks<>(2);
    }

    @Test
    void push() {
        final IStack<Integer> stack = getStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertEquals(2, stack.getHeight());
        stack.push(3);
        assertEquals(3, stack.getHeight());
    }

    @Test
    void pop() {
        final IStack<Integer> stack = getStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.pop());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
    }

    @Test
    void peek() {
        final IStack<Integer> stack = getStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(Integer.valueOf(1), stack.peek());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.peek());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    void isEmpty() {
        final IStack<Integer> stack = getStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }


    @Test
    void getHeight() {
        final IStack<Integer> stack = getStack();
        assertEquals(0, stack.getHeight());
        stack.push(1);
        assertEquals(1, stack.getHeight());
        stack.push(2);
        assertEquals(2, stack.getHeight());
        stack.pop();
        assertEquals(1, stack.getHeight());
        stack.pop();
        assertEquals(0, stack.getHeight());
        stack.push(3);
        assertEquals(1, stack.getHeight());
        stack.pop();
        assertEquals(0, stack.getHeight());
    }
}