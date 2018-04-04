package net.signedbit.fun.ctci;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MyHeap<T extends Comparable> {
    private final List<T> list = new ArrayList<>(Collections.singleton(null));
    private int size;

    public void insert(final T value) {
        Preconditions.checkArgument(value != null);

        list.add(value);
        size++;

        heapify();
    }

    public T peek_min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(1);
    }

    public T extract_min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        final T min = list.remove(1);
        size--;

        heapify();

        return min;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void heapify() {
        for (int i = size(); i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(final int index) {
        final int parent = parent(index);
        int smallest = index;

        if (parent > 0 && list.get(smallest).compareTo(list.get(parent)) < 0) {
            smallest = parent;
        }
        if (index != smallest) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(final int parentIdx, final int childIdx) {
        final T parent = list.get(parentIdx);
        final T child = list.get(childIdx);
        list.set(parentIdx, child);
        list.set(childIdx, parent);
    }

    private int parent(final int index) {
        return index / 2;
    }

    private int left(final int index) {
        return 2 * index;
    }

    private int right(final int index) {
        return 2 * index + 1;
    }
}
