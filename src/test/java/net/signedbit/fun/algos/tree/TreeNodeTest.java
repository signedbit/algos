package net.signedbit.fun.algos.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {
    @Test
    void getLeft() {
        final TreeNode<Integer> expected = new TreeNode<>(0);
        final TreeNode<Integer> actual = new TreeNode<>(1, new TreeNode<>(0), null).getLeft();

        assertEquals(expected, actual);
    }

    @Test
    void setLeft() {
        final TreeNode<Integer> node = new TreeNode<>(1, null, null);
        node.setLeft(new TreeNode<>(0));

        final TreeNode<Integer> expected = new TreeNode<>(0);
        final TreeNode<Integer> actual = node.getLeft();

        assertEquals(expected, actual);
    }

    @Test
    void getRight() {
        final TreeNode<Integer> expected = new TreeNode<>(1);
        final TreeNode<Integer> actual = new TreeNode<>(1, null, new TreeNode<>(1)).getRight();

        assertEquals(expected, actual);
    }

    @Test
    void setRight() {
        final TreeNode<Integer> node = new TreeNode<>(1, null, null);
        node.setRight(new TreeNode<>(2));

        final TreeNode<Integer> expected = new TreeNode<>(2);
        final TreeNode<Integer> actual = node.getRight();

        assertEquals(expected, actual);
    }

    @Test
    void getData() {
        final int expected = 1;
        final int actual = new TreeNode<>(1, null, null).getData();

        assertEquals(expected, actual);
    }

    @Test
    void setData() {
        final TreeNode<Integer> node = new TreeNode<>(1, null, null);
        node.setData(2);

        final int expected = 2;
        final int actual = node.getData();

        assertEquals(expected, actual);
    }

    @Test
    void isLeafWithNoChildren() {
        final boolean expected = true;
        final boolean actual = new TreeNode<>(1, null, null).isLeaf();

        assertEquals(expected, actual);
    }

    @Test
    void isNotLeafWithLeftChild() {
        final boolean expected = false;
        final boolean actual = new TreeNode<>(1, new TreeNode<>(0), null).isLeaf();

        assertEquals(expected, actual);
    }


    @Test
    void isNotLeafWithRightChild() {
        final boolean expected = false;
        final boolean actual = new TreeNode<>(1, null, new TreeNode<>(2)).isLeaf();

        assertEquals(expected, actual);
   }
    @Test
    void isNotLeafWithBothChildren() {
        final boolean expected = false;
        final boolean actual = new TreeNode<>(1, new TreeNode<>(0), new TreeNode<>(2)).isLeaf();

        assertEquals(expected, actual);
   }
}