package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackTest {
    @Test
    void getMinimum() {
        final MinStack<Integer> stack = new MinStack<>();

        stack.push(5);
        assertEquals(Integer.valueOf(5), stack.getMinimum());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.push(8);
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.getMinimum());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.pop();
        assertEquals(Integer.valueOf(3), stack.getMinimum());
        stack.pop();
        assertEquals(Integer.valueOf(5), stack.getMinimum());
    }
}
