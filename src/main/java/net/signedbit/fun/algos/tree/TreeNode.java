package net.signedbit.fun.algos.tree;

import java.util.Objects;

public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode(final T data) {
        this(data, null, null);
    }

    public TreeNode(final T data, final TreeNode<T> left, final TreeNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(final TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(final TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return getLeft() == null && getRight() == null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(getLeft(), treeNode.getLeft()) &&
                Objects.equals(getRight(), treeNode.getRight()) &&
                Objects.equals(getData(), treeNode.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight(), getData());
    }
}
