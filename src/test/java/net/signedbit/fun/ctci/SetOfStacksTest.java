package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetOfStacksTest {
    @Test
    void push() {
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
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
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.pop());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
    }


    @Test
    void popAt() {
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.getHeight());
        assertEquals(Integer.valueOf(2), stack.popAt(0));
        assertEquals(2, stack.getHeight());
        assertEquals(Integer.valueOf(1), stack.popAt(0));
        assertEquals(1, stack.getHeight());
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peek() {
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
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
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
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
        final SetOfStacks<Integer> stack = new SetOfStacks<>(2);
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