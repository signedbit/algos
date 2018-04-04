package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void getRoot() {
        assertNull(new BinarySearchTree<>().getRoot());
        assertEquals("foo", new BinarySearchTree<>("foo").getRoot().getValue());
        assertEquals("bar", new BinarySearchTree<>("bar").getRoot().getValue());
    }

    @Test
    void add() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertNull(tree.getRoot());

        tree.add(5);
        assertTrue(tree.getRoot().isLeaf());
        assertEquals(Integer.valueOf(5), tree.getRoot().getValue());

        tree.add(3);
        assertFalse(tree.getRoot().isLeaf());
        assertEquals(Integer.valueOf(5), tree.getRoot().getValue());
        assertEquals(Integer.valueOf(3), tree.getRoot().getLeft().getValue());

        tree.add(7);
        assertFalse(tree.getRoot().isLeaf());
        assertEquals(Integer.valueOf(5), tree.getRoot().getValue());
        assertEquals(Integer.valueOf(7), tree.getRoot().getRight().getValue());

        tree.add(4);
        assertFalse(tree.getRoot().isLeaf());
        assertEquals(Integer.valueOf(5), tree.getRoot().getValue());
        assertEquals(Integer.valueOf(4), tree.getRoot().getLeft().getRight().getValue());

        tree.add(6);
        assertFalse(tree.getRoot().isLeaf());
        assertEquals(Integer.valueOf(5), tree.getRoot().getValue());
        assertEquals(Integer.valueOf(6), tree.getRoot().getRight().getLeft().getValue());
    }
}