package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {
    private LinkedLists ll = new LinkedLists();

    @Test
    void removeDuplicates() {
        assertEquals(new MyLinkedList<>(1, 2), ll.removeDuplicates(new MyLinkedList<>(1, 2, 2)));
        assertEquals(new MyLinkedList<>(1, 2, 3), ll.removeDuplicates(new MyLinkedList<>(1, 2, 3)));
        assertEquals(new MyLinkedList<>(1, 2), ll.removeDuplicates(new MyLinkedList<>(1, 1, 2)));
    }

    @Test
    void kthToLast() {
        assertNull(ll.kthToLast(0, null));
        assertNull(ll.kthToLast(-1, new MyLinkedList<>(1, 2, 3)));
        assertNull(ll.kthToLast(10, new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(3), ll.kthToLast(0, new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(2), ll.kthToLast(1, new MyLinkedList<>(1, 2, 3)));
    }

    @Test
    void deleteMiddleNode() {
        assertFalse(ll.deleteMiddleNode(1, null));
        assertFalse(ll.deleteMiddleNode(2, new MyLinkedList<>(2, 3, 4, 5)));
        assertFalse(ll.deleteMiddleNode(5, new MyLinkedList<>(2, 3, 4, 5)));
        assertTrue(ll.deleteMiddleNode(2, new MyLinkedList<>(1, 2, 3)));
        assertTrue(ll.deleteMiddleNode(3, new MyLinkedList<>(1, 2, 3, 4)));
    }

    @Test
    void partition() {
        assertNull(ll.partition(1, null));
        assertEquals(new MyIntLinkedList(2, 3, 4, 5), ll.partition(1, new MyIntLinkedList(2, 3, 4, 5)));
        assertEquals(new MyIntLinkedList(2, 3, 4, 5), ll.partition(3, new MyIntLinkedList(2, 3, 4, 5)));
        assertEquals(new MyIntLinkedList(1, 5, 4, 3, 2), ll.partition(2, new MyIntLinkedList(5, 4, 3, 2, 1)));
        assertEquals(new MyIntLinkedList(2, 1, 5, 4, 3), ll.partition(3, new MyIntLinkedList(5, 4, 3, 2, 1)));
        assertEquals(new MyIntLinkedList(3, 2, 1, 5, 8, 5, 10), ll.partition(5, new MyIntLinkedList(3, 5, 8, 5, 10, 2, 1)));
    }

    @Test
    void sumListBackward() {
        assertNull(ll.sumListBackward(null, new MyIntLinkedList(5, 9, 2)));
        assertNull(ll.sumListBackward(new MyIntLinkedList(7, 1, 6), null));
        assertNull(ll.sumListBackward(null, null));
        assertEquals(new MyIntLinkedList(2, 1, 9), ll.sumListBackward(new MyIntLinkedList(7, 1, 6), new MyIntLinkedList(5, 9, 2)));
        assertEquals(new MyIntLinkedList(4, 3, 2, 1), ll.sumListBackward(new MyIntLinkedList(7, 6, 5), new MyIntLinkedList(7, 6, 6)));
        assertEquals(new MyIntLinkedList(4, 3, 2, 1), ll.sumListBackward(new MyIntLinkedList(1, 0), new MyIntLinkedList(3, 3, 2, 1)));
    }

    @Test
    void sumListForward() {
        assertNull(ll.sumListForward(null, new MyIntLinkedList(5, 9, 2)));
        assertNull(ll.sumListForward(new MyIntLinkedList(7, 1, 6), null));
        assertNull(ll.sumListForward(null, null));
        assertEquals(new MyIntLinkedList(9, 1, 2), ll.sumListForward(new MyIntLinkedList(6, 1, 7), new MyIntLinkedList(2, 9, 5)));
        assertEquals(new MyIntLinkedList(1, 2, 3, 4), ll.sumListForward(new MyIntLinkedList(5, 6, 7), new MyIntLinkedList(6, 6, 7)));
        assertEquals(new MyIntLinkedList(1, 2, 3, 4), ll.sumListForward(new MyIntLinkedList(1), new MyIntLinkedList(1, 2, 3, 3)));
    }

    @Test
    void isPalindrome() {
        assertFalse(ll.isPalindrome(null));
        assertFalse(ll.isPalindrome(new MyLinkedList<>(5, 9, 2)));
        assertFalse(ll.isPalindrome(new MyLinkedList<>(1, 2)));
        assertFalse(ll.isPalindrome(new MyLinkedList<>(1, 2, 3)));
        assertFalse(ll.isPalindrome(new MyLinkedList<>(1, 2, 3, 4)));
        assertFalse(ll.isPalindrome(new MyLinkedList<>(1, 2, 3, 4, 1)));

        assertTrue(ll.isPalindrome(new MyLinkedList<>()));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 2, 1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 2, 2, 1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 2, 3, 2, 1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 1, 1, 1)));
        assertTrue(ll.isPalindrome(new MyLinkedList<Integer>(1, 1, 1, 1, 1)));
    }

    @Test
    void intersection() {
        assertNull(ll.intersection(null, new MyLinkedList<>()));
        assertNull(ll.intersection(new MyLinkedList<>(), null));
        assertNull(ll.intersection(null, null));
        assertNull(ll.intersection(new MyLinkedList<>(1), new MyLinkedList<>()));
        assertNull(ll.intersection(new MyLinkedList<>(), new MyLinkedList<>(1)));
        assertNull(ll.intersection(new MyLinkedList<>(), new MyLinkedList<>(1, 2, 3)));
        assertNull(ll.intersection(new MyLinkedList<>(1, 2, 3), new MyLinkedList<>(4, 5, 6)));

        assertEquals(Integer.valueOf(3), ll.intersection(new MyLinkedList<>(6, 5, 4, 3), new MyLinkedList<>(1, 2, 3)));
        assertEquals(Integer.valueOf(2), ll.intersection(new MyLinkedList<>(1, 2, 3), new MyLinkedList<>(2)));
        assertEquals(Integer.valueOf(2), ll.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(2)));
        assertEquals(Integer.valueOf(2), ll.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(2)));
        assertEquals(Integer.valueOf(1), ll.intersection(new MyLinkedList<>(3, 2, 1), new MyLinkedList<>(1, 2, 3)));
    }

    @Test
    void hasLoop() {
        final MyNodeLinkedList<Integer> list = new MyNodeLinkedList<>(
                new MyLinkedList.Node<>(6),
                new MyLinkedList.Node<>(5),
                new MyLinkedList.Node<>(4),
                new MyLinkedList.Node<>(3)
        );

        assertNull(ll.hasLoop(null));
        assertNull(ll.hasLoop(list));

        list.append(new MyNodeLinkedList.Node<>(2));
        assertNull(ll.hasLoop(list));

        for (int i = list.getSize() - 1; i >= 0; i--) {
            list.getLast().next = list.get(i);
            assertEquals(list.get(i).data, ll.hasLoop(list));

            list.getLast().next = null;
            assertNull(ll.hasLoop(list));
        }
    }
}