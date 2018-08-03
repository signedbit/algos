package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void getValue() {
        assertEquals("foo", t("foo").getValue());
        assertEquals("bar", t("bar").getValue());
        assertNull(t(null).getValue());
    }

    @Test
    void getParent() {
        assertNull(t("foo").getParent());
        assertEquals("foo", t("foo", t("bar"), null).getLeft().getParent().getValue());
        assertEquals("foo", t("foo", null, t("bar")).getRight().getParent().getValue());
    }

    @Test
    void getLeft() {
        assertNull(t("foo").getLeft());
        assertEquals("bar", t("foo", t("bar"), null).getLeft().getValue());
    }

    @Test
    void getRight() {
        assertNull(t("foo").getRight());
        assertEquals("bar", t("foo", null, t("bar")).getRight().getValue());
    }

    @Test
    void setLeft() {
        final BinaryTree<String> tree = t("foo");
        tree.setLeft(t("bar"));
        assertEquals("bar", tree.getLeft().getValue());
        tree.setLeft(t("baz"));
        tree.setLeft(t("qux"));
        assertEquals("qux", tree.getLeft().getValue());
        tree.getLeft().setLeft(t("qixx"));
        assertEquals("qixx", tree.getLeft().getLeft().getValue());
    }

    @Test
    void setRight() {
        final BinaryTree<String> tree = t("foo");
        tree.setRight(t("bar"));
        assertEquals("bar", tree.getRight().getValue());
        tree.setRight(t("baz"));
        tree.setRight(t("qux"));
        assertEquals("qux", tree.getRight().getValue());
        tree.getRight().setRight(t("qixx"));
        assertEquals("qixx", tree.getRight().getRight().getValue());
    }

    @Test
    void isLeaf() {
        assertTrue(t("foo").isLeaf());
        assertFalse(t("foo", t("bar"), null).isLeaf());
        assertFalse(t("foo", null, t("bar")).isLeaf());
        assertFalse(t("foo", t("bar"), t("baz")).isLeaf());
        assertFalse(t("foo", t("bar", t("baz"), null), null).isLeaf());
        assertTrue(t("foo", null, t("bar")).getRight().isLeaf());
        assertTrue(t("foo", t("bar"), null).getLeft().isLeaf());
        assertTrue(t("foo", t("bar"), null).getLeft().isLeaf());
        assertTrue(t("foo", null, t("bar")).getRight().isLeaf());
    }

    @Test
    void isRoot() {
        assertTrue(t("foo").isRoot());
        assertFalse(t("foo", t("foo"), null).getLeft().isRoot());
        assertFalse(t("foo", null, t("foo")).getRight().isRoot());
    }

    @Test
    void getHeight() {
        assertEquals(1, t("foo").getHeight());
        assertEquals(2, t("foo", t("bar"), null).getHeight());
        assertEquals(2, t("foo", null, t("bar")).getHeight());
        assertEquals(3, t("foo", t("bar", t("bar"), null), null).getHeight());
        assertEquals(3, t("foo", null, t("bar", t("bar"), null)).getHeight());
        assertEquals(3, t("foo", null, t("bar", t("bar"), t("baz"))).getHeight());
    }

    private <T extends Comparable> BinaryTree<T> t(final T value) {
        return new BinaryTree<>(value);
    }

    private <T extends Comparable> BinaryTree<T> t(final T value, final BinaryTree<T> left, final BinaryTree<T> right) {
        return new BinaryTree<>(value, left, right);
    }
}