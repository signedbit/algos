package net.signedbit.fun.ctci;

public class BinaryTree<T extends Comparable> {
    private T value;

    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(final T value) {
        setValue(value);
    }

    public BinaryTree(final T value, final BinaryTree<T> left, final BinaryTree<T> right) {
        this(value);

        setLeft(left);
        setRight(right);
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setLeft(final BinaryTree<T> left) {
        if (this.left != null) {
            this.parent = null;
        }
        if (left != null) {
            left.parent = this;
        }
        this.left = left;
    }

    public void setRight(final BinaryTree<T> right) {
        if (this.right != null) {
            this.parent = null;
        }
        if (right != null) {
            right.parent = this;
        }
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isRoot() {
        return getParent() == null;
    }

    public int getHeight() {
        final int left = getLeft() != null ? getLeft().getHeight() : 0;
        final int right = getRight() != null ? getRight().getHeight() : 0;
        return 1 + Math.max(left, right);
    }
}