package net.signedbit.fun.algos;

import net.signedbit.fun.ctci.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StacksTest {
    final Stacks clz = new Stacks();

    @Test
    void sort() {
        assertNull(clz.sort(null));

        assertEquals(new MyStack<>(3, 2, 1), clz.sort(new MyStack<>(1, 2, 3)));
        assertEquals(new MyStack<>(5, 4, 3, 2, 1), clz.sort(new MyStack<>(1, 2, 3, 4, 5)));
        assertEquals(new MyStack<>(5, 4, 3, 3, 2), clz.sort(new MyStack<>(3, 2, 3, 4, 5)));
        assertEquals(new MyStack<>(1, 1, 1, 1, 1), clz.sort(new MyStack<>(1, 1, 1, 1, 1)));
        assertEquals(new MyStack<>(100, 10, 1, -10, -100), clz.sort(new MyStack<>(-100, 100, -10, 10, 1)));
    }

}