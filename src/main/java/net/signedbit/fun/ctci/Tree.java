package net.signedbit.fun.ctci;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<T> {
    private T data;
    private Tree<T> parent;
    private List<Tree<T>> children = new ArrayList<>();

    public Tree(final T data, final Tree<T>... children) {
        this.data = data;

        addAllChildren(Arrays.asList(children));
    }

    public void addAllChildren(final List<Tree<T>> trees) {
        for (final Tree<T> tree : trees) {
            addChild(tree);
        }
    }

    public void addChild(final Tree<T> tree) {
        children.add(tree);
        tree.parent = this;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void removeChild(final Tree<T> tree) {
        Preconditions.checkArgument(children.contains(tree));

        children.remove(tree);
        tree.parent = null;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
