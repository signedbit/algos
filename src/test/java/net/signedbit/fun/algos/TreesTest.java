package net.signedbit.fun.algos;

import net.signedbit.fun.ctci.BinaryTree;
import net.signedbit.fun.ctci.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TreesTest {
    private Trees clz = new Trees();

    @Test
    void isCompleteTree() {
        final BinaryTree<Integer> tree1 = t(1);
        assertTrue(clz.isCompleteTree(tree1));

        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        assertTrue(clz.isCompleteTree(tree2));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        assertFalse(clz.isCompleteTree(tree3));

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        assertTrue(clz.isCompleteTree(tree4));

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3), null), t(4));
        assertTrue(clz.isCompleteTree(tree5));

        final BinaryTree<Integer> tree6 = t(1, t(2, null, t(3)), t(4));
        assertFalse(clz.isCompleteTree(tree6));

        final BinaryTree<Integer> tree7 = t(1, t(2), t(3, t(4), null));
        assertFalse(clz.isCompleteTree(tree7));

        final BinaryTree<Integer> tree8 = t(1, t(2), t(3, null, t(4)));
        assertFalse(clz.isCompleteTree(tree8));

        final BinaryTree<Integer> tree9 = t(10, t(5, t(3), t(7)), t(20, null, t(30)));
        assertFalse(clz.isCompleteTree(tree9));

        final BinaryTree<Integer> tree10 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        assertTrue(clz.isCompleteTree(tree10));
    }

    @Test
    void isFullTree() {
        final BinaryTree<Integer> tree1 = t(1);
        assertTrue(clz.isFullTree(tree1));

        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        assertFalse(clz.isFullTree(tree2));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        assertFalse(clz.isFullTree(tree3));

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        assertTrue(clz.isFullTree(tree4));

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3), null), t(4));
        assertFalse(clz.isFullTree(tree5));

        final BinaryTree<Integer> tree6 = t(1, t(2, null, t(3)), t(4));
        assertFalse(clz.isFullTree(tree6));

        final BinaryTree<Integer> tree7 = t(1, t(2), t(3, t(4), null));
        assertFalse(clz.isFullTree(tree7));

        final BinaryTree<Integer> tree8 = t(1, t(2), t(3, null, t(4)));
        assertFalse(clz.isFullTree(tree8));

        final BinaryTree<Integer> tree9 = t(10, t(5, t(3), t(7)), t(20, null, t(30)));
        assertFalse(clz.isFullTree(tree9));

        final BinaryTree<Integer> tree10 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        assertFalse(clz.isFullTree(tree10));

        final BinaryTree<Integer> tree11 = t(10, t(5, null, t(3)), t(20, t(3, t(9), t(18)), t(7)));
        assertFalse(clz.isFullTree(tree11));
    }

    @Test
    void isPerfectTree() {
        final BinaryTree<Integer> tree1 = t(1);
        assertTrue(clz.isPerfectTree(tree1));

        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        assertFalse(clz.isPerfectTree(tree2));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        assertFalse(clz.isPerfectTree(tree3));

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        assertTrue(clz.isPerfectTree(tree4));

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3), t(4)), t(5));
        assertFalse(clz.isPerfectTree(tree5));

        final BinaryTree<Integer> tree6 = t(1, t(2), t(3, t(4), t(5)));
        assertFalse(clz.isPerfectTree(tree6));

        final BinaryTree<Integer> tree7 = t(1, t(2, t(3), t(4)), t(5, t(6), t(7)));
        assertTrue(clz.isPerfectTree(tree7));

        final BinaryTree<Integer> tree8 = t(1, t(2, t(3, t(4), t(5)), t(6, t(7), t(8))), t(9, t(10, t(11), t(12)), t(13, t(14), t(15))));
        assertTrue(clz.isPerfectTree(tree8));
    }

    @Test
    void preorder() {
    }

    @Test
    void inorder() {
    }

    @Test
    void postorder() {
    }

    @Test
    void buildMinimalTree() {
        final List<Integer> nums = IntStream.rangeClosed(0, 33).boxed().collect(Collectors.toList());
        for (int i = 1; i < 34; i++) {
            final BinaryTree<Integer> tree = clz.buildMinimalTree(nums.subList(0, i));
            assertEquals((int) Math.ceil(log2(i + 1)), tree.getHeight());
        }
    }

    private double log2(final int n) {
        return Math.log(n) / Math.log(2);
    }

    @Test
    void listOfDepths() {
        final BinaryTree<Integer> tree1 = t(1);
        assertEquals(new MyLinkedList<>(1), clz.listOfDepths(tree1).get(0));

        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        assertEquals(new MyLinkedList<>(1), clz.listOfDepths(tree2).get(0));
        assertEquals(new MyLinkedList<>(2), clz.listOfDepths(tree2).get(1));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        assertEquals(new MyLinkedList<>(1), clz.listOfDepths(tree3).get(0));
        assertEquals(new MyLinkedList<>(2), clz.listOfDepths(tree3).get(1));

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        assertEquals(new MyLinkedList<>(1), clz.listOfDepths(tree4).get(0));
        assertEquals(new MyLinkedList<>(2, 3), clz.listOfDepths(tree4).get(1));

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3), null), t(4));
        assertEquals(new MyLinkedList<>(1), clz.listOfDepths(tree5).get(0));
        assertEquals(new MyLinkedList<>(2, 4), clz.listOfDepths(tree5).get(1));
        assertEquals(new MyLinkedList<>(3), clz.listOfDepths(tree5).get(2));

        final BinaryTree<Integer> tree6 = t(10, t(5, t(3), t(7)), t(20, null, t(30)));
        assertEquals(new MyLinkedList<>(10), clz.listOfDepths(tree6).get(0));
        assertEquals(new MyLinkedList<>(5, 20), clz.listOfDepths(tree6).get(1));
        assertEquals(new MyLinkedList<>(3, 7, 30), clz.listOfDepths(tree6).get(2));

        final BinaryTree<Integer> tree7 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        assertEquals(new MyLinkedList<>(10), clz.listOfDepths(tree7).get(0));
        assertEquals(new MyLinkedList<>(5, 20), clz.listOfDepths(tree7).get(1));
        assertEquals(new MyLinkedList<>(3, 7, 15), clz.listOfDepths(tree7).get(2));
    }

    @Test
    void isBalanced() {
        assertTrue(clz.isBalanced(t(1)));

        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        assertTrue(clz.isBalanced(tree2));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        assertTrue(clz.isBalanced(tree3));

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        assertTrue(clz.isBalanced(tree4));

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3, t(4), null), null), t(4));
        assertFalse(clz.isBalanced(tree5));

        final BinaryTree<Integer> tree6 = t(10, t(5, t(3), t(7)), t(20, null, t(30)));
        assertTrue(clz.isBalanced(tree6));

        final BinaryTree<Integer> tree7 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        assertTrue(clz.isBalanced(tree7));

        final BinaryTree<Integer> tree8 = t(10, t(5, t(3), t(7)), t(20, t(15, t(14), null), null));
        assertFalse(clz.isBalanced(tree8));
    }

    @Test
    void successor() {
        final BinaryTree<Integer> tree2 = t(1, t(2), null);
        verify(tree2);

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        verify(tree3);

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        verify(tree4);

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3, t(4), null), null), t(4));
        verify(tree5);

        final BinaryTree<Integer> tree6 = t(10, t(5, t(3), t(7)), t(20, t(15), t(30)));
        verify(tree6);

        final BinaryTree<Integer> tree7 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        verify(tree7);

        final BinaryTree<Integer> tree8 = t(10, t(5, t(3), t(7)), t(20, t(15, t(14), null), null));
        verify(tree8);
    }

    private <T extends Comparable> void verify(final BinaryTree<T> tree) {
        final List<BinaryTree<T>> inorder = clz.inorder(tree);
        for (int i = 0; i < inorder.size() - 2; i++) {
            final T expected = inorder.get(i + 1).getValue();
            final T actual = clz.successor(inorder.get(i)).getValue();

            assertEquals(expected, actual);
        }
    }

    @Test
    void firstCommonAncestor() {
//        final BinaryTree<Integer> tree2 = t(1, t(2), null);
//        assertEquals(1, clz.firstCommonAncestor(t(1), t(2)));

        final BinaryTree<Integer> tree3 = t(1, null, t(2));
        verify(tree3);

        final BinaryTree<Integer> tree4 = t(1, t(2), t(3));
        verify(tree4);

        final BinaryTree<Integer> tree5 = t(1, t(2, t(3, t(4), null), null), t(4));
        verify(tree5);

        final BinaryTree<Integer> tree6 = t(10, t(5, t(3), t(7)), t(20, t(15), t(30)));
        verify(tree6);

        final BinaryTree<Integer> tree7 = t(10, t(5, t(3), t(7)), t(20, t(15), null));
        verify(tree7);

        final BinaryTree<Integer> tree8 = t(10, t(5, t(3), t(7)), t(20, t(15, t(14), null), null));
        verify(tree8);
    }

    private <T extends Comparable> BinaryTree<T> t(final T value) {
        return new BinaryTree<>(value);
    }

    private <T extends Comparable> BinaryTree<T> t(final T value, final BinaryTree<T> left, final BinaryTree<T> right) {
        return new BinaryTree<>(value, left, right);
    }
}