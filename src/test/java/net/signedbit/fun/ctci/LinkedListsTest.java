package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {
    private LinkedLists clz = new LinkedLists();

    @Test
    void removeDuplicates() {
        assertEquals(new MyLinkedList<>(1, 2), clz.removeDuplicates(new MyLinkedList<>(1, 2, 2)));
        assertEquals(new MyLinkedList<>(1, 2, 3), clz.removeDuplicates(new MyLinkedList<>(1, 2, 3)));
        assertEquals(new MyLinkedList<>(1, 2), clz.removeDuplicates(new MyLinkedList<>(1, 1, 2)));
    }

    @Test
    void kthToLast() {
        assertEquals(null, clz.kthToLast(0, null));
        assertEquals(null, clz.kthToLast(-1, new MyLinkedList<>(1, 2, 3)));
        assertEquals(null, clz.kthToLast(10, new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(3), clz.kthToLast(0, new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(2), clz.kthToLast(1, new MyLinkedList<>(1, 2, 3)));
    }

    @Test
    void deleteMiddleNode() {
        assertFalse(clz.deleteMiddleNode(1, null));
        assertFalse(clz.deleteMiddleNode(2, new MyLinkedList<>(2, 3, 4, 5)));
        assertFalse(clz.deleteMiddleNode(5, new MyLinkedList<>(2, 3, 4, 5)));
        assertTrue(clz.deleteMiddleNode(2, new MyLinkedList<>(1, 2, 3)));
        assertTrue(clz.deleteMiddleNode(3, new MyLinkedList<>(1, 2, 3, 4)));
    }

    @Test
    void partition() {
        assertEquals(null, clz.partition(1, null));
        assertEquals(new MyIntLinkedList(2, 3, 4, 5), clz.partition(1, new MyIntLinkedList(2, 3, 4, 5)));
        assertEquals(new MyIntLinkedList(2, 3, 4, 5), clz.partition(3, new MyIntLinkedList(2, 3, 4, 5)));
        assertEquals(new MyIntLinkedList(1, 5, 4, 3, 2), clz.partition(2, new MyIntLinkedList(5, 4, 3, 2, 1)));
        assertEquals(new MyIntLinkedList(2, 1, 5, 4, 3), clz.partition(3, new MyIntLinkedList(5, 4, 3, 2, 1)));
        assertEquals(new MyIntLinkedList(3, 2, 1, 5, 8, 5, 10), clz.partition(5, new MyIntLinkedList(3, 5, 8, 5, 10, 2, 1)));
    }

    @Test
    void sumListBackward() {
        assertEquals(null, clz.sumListBackward(null, new MyIntLinkedList(5, 9, 2)));
        assertEquals(null, clz.sumListBackward(new MyIntLinkedList(7, 1, 6), null));
        assertEquals(null, clz.sumListBackward(null, null));
        assertEquals(new MyIntLinkedList(2, 1, 9), clz.sumListBackward(new MyIntLinkedList(7, 1, 6), new MyIntLinkedList(5, 9, 2)));
        assertEquals(new MyIntLinkedList(4, 3, 2, 1), clz.sumListBackward(new MyIntLinkedList(7, 6, 5), new MyIntLinkedList(7, 6, 6)));
        assertEquals(new MyIntLinkedList(4, 3, 2, 1), clz.sumListBackward(new MyIntLinkedList(1, 0), new MyIntLinkedList(3, 3, 2, 1)));
    }

    @Test
    void sumListForward() {
        assertEquals(null, clz.sumListForward(null, new MyIntLinkedList(5, 9, 2)));
        assertEquals(null, clz.sumListForward(new MyIntLinkedList(7, 1, 6), null));
        assertEquals(null, clz.sumListForward(null, null));
        assertEquals(new MyIntLinkedList(9, 1, 2), clz.sumListForward(new MyIntLinkedList(6, 1, 7), new MyIntLinkedList(2, 9, 5)));
        assertEquals(new MyIntLinkedList(1, 2, 3, 4), clz.sumListForward(new MyIntLinkedList(5, 6, 7), new MyIntLinkedList(6, 6, 7)));
        assertEquals(new MyIntLinkedList(1, 2, 3, 4), clz.sumListForward(new MyIntLinkedList(1), new MyIntLinkedList(1, 2, 3, 3)));
    }

    @Test
    void isPalindrome() {
        assertFalse(clz.isPalindrome(null));
        assertFalse(clz.isPalindrome(new MyLinkedList<>(5, 9, 2)));
        assertFalse(clz.isPalindrome(new MyLinkedList<>(1, 2)));
        assertFalse(clz.isPalindrome(new MyLinkedList<>(1, 2, 3)));
        assertFalse(clz.isPalindrome(new MyLinkedList<>(1, 2, 3, 4)));
        assertFalse(clz.isPalindrome(new MyLinkedList<>(1, 2, 3, 4, 1)));


        assertTrue(clz.isPalindrome(new MyLinkedList<>()));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 2, 1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 2, 2, 1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 2, 3, 2, 1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 1, 1, 1)));
        assertTrue(clz.isPalindrome(new MyLinkedList<Integer>(1, 1, 1, 1, 1)));
    }

    @Test
    void intersection() {
        assertNull(clz.intersection(null, new MyLinkedList<>()));
        assertNull(clz.intersection(new MyLinkedList<>(), null));
        assertNull(clz.intersection(null, null));
        assertNull(clz.intersection(new MyLinkedList<>(1), new MyLinkedList<>()));
        assertNull(clz.intersection(new MyLinkedList<>(), new MyLinkedList<>(1)));
        assertNull(clz.intersection(new MyLinkedList<>(), new MyLinkedList<>(1, 2, 3)));

        assertEquals(Integer.valueOf(3), clz.intersection(new MyLinkedList<>(6, 5, 4, 3), new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(2), clz.intersection(new MyLinkedList<>(1, 2, 3), new MyLinkedList<>(2)));
        assertEquals(Integer.valueOf(2), clz.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(2)));
        assertEquals(Integer.valueOf(2), clz.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(2)));
        assertNull(clz.intersection(new MyLinkedList<>(1, 2, 3), new MyLinkedList<>(4, 5, 6)));
        assertEquals(Integer.valueOf(1), clz.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(1, 2, 3)));
    }

    @Test
    void hasLoop() {
        final MyNodeLinkedList<Integer> list = new MyNodeLinkedList<>(
                new MyLinkedList.Node<>(6),
                new MyLinkedList.Node<>(5),
                new MyLinkedList.Node<>(4),
                new MyLinkedList.Node<>(3)
        );

        assertNull(clz.hasLoop(null));
        assertNull(clz.hasLoop(list));

        list.append(new MyNodeLinkedList.Node<>(2));
        assertNull(clz.hasLoop(list));

        for (int i = list.getSize() - 1; i >= 0; i--) {
            list.getLast().next = list.get(i);
            assertEquals(list.get(i).data, clz.hasLoop(list));

            list.getLast().next = null;
            assertNull(clz.hasLoop(list));
        }
    }
}