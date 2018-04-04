package net.signedbit.fun.ctci;

public class BinarySearchTree<T extends Comparable> {
    private BinaryTree<T> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(final T... values) {
        for (final T value : values) {
            add(value);
        }
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public void add(final T value) {
        if (root == null) {
            root = new BinaryTree<>(value);
            return;
        }
        add(value, root);
    }

    private void add(final T value, final BinaryTree<T> root) {
        if (value.compareTo(root.getValue()) <= 0) {
            if (root.getLeft() == null) {
                root.setLeft(new BinaryTree<>(value));
            } else {
                add(value, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new BinaryTree<>(value));
            } else {
                add(value, root.getRight());
            }
        }
    }

    private void balance(final BinaryTree<T> root) {

    }
}