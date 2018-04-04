package net.signedbit.fun.ctci;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Trie<T> {
    private T datum;
    private Trie<T> parent;
    private Map<T, Trie<T>> children = new HashMap<>();

    public Trie(final T datum) {
        this.datum = datum;
    }

    public Trie(final T datum, final Trie<T>... children) {
        this(datum);

        for (final Trie<T> child : children) {
            addChild(child);
        }
    }

    public Trie<T> getParent() {
        return parent;
    }

    public void setParent(final Trie<T> parent) {
        parent.addChild(this);
    }

    public T getDatum() {
        return datum;
    }

    public T[] getData() {
        final List<T> data = new LinkedList<>();
        Trie<T> trie = this;
        while (trie != null) {
            data.add(0, trie.getDatum());
            trie = trie.getParent();
        }
        return (T[]) data.toArray();
    }

    public boolean hasPrefix(final T[] prefix) {
        return hasPrefix(prefix, 0);
    }

    private boolean hasPrefix(final T[] prefix, final int start) {
        if (start == prefix.length) {
            return true;
        }
        final Map<T, Trie<T>> children = getChildren();
        final T datum = prefix[start];
        if (children.containsKey(datum)) {
            return children.get(datum).hasPrefix(prefix, start + 1);
        }
        return false;
    }

    public void addAllChildren(final T[]... children) {
        for (final T[] child : children) {
            addChildren(child);
        }
    }

    public void addChildren(final T[] data) {
        addChildren(data, 0);
    }

    private void addChildren(final T[] data, final int start) {
        if (start >= data.length) {
            return;
        }

        final T datum = data[start];
        final Trie<T> child = addChild(datum);
        child.addChildren(data, start + 1);
    }

    private Trie<T> addChild(final T datum) {
        return addChild(new Trie<>(datum));
    }

    private Trie<T> addChild(final Trie<T> trie) {
        trie.parent = this;
        if (!children.containsKey(trie.getDatum())) {
            children.put(trie.getDatum(), trie);
            return trie;
        } else {
            final Trie<T> current = children.get(trie.getDatum());
            for (final Trie<T> child : trie.getChildren().values()) {
                current.addChild(child);
            }
            return current;
        }
    }

    public Map<T, Trie<T>> getChildren() {
        return children;
    }

    public void removeChild(final Trie<T> tree) {
        removeChild(tree.datum);
    }

    private void removeChild(final T datum) {
        Preconditions.checkArgument(getChildren().containsKey(datum));

        getChildren().remove(datum).setParent(null);
    }

    public boolean isRoot() {
        return getParent() == null;
    }

    public boolean isLeaf() {
        return getChildren().isEmpty();
    }

    public Trie<T> getChild(final T datum) {
        return getChildren().get(datum);
    }
}
