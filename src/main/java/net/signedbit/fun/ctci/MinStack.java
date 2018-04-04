package net.signedbit.fun.ctci;

import java.util.NoSuchElementException;

public class MinStack<T extends Comparable> extends MyStack<T> {
    private MyStack<T> minimums = new MyStack<>();

    @Override
    public void push(final T item) {
        if (isEmpty()) {
            minimums.push(item);
        } else {
            minimums.push(minimum(item, minimums.peek()));
        }
        super.push(item);
    }

    private T minimum(final T first, final T second) {
        final int cmp = first.compareTo(second);
        return cmp > 0 ? second : first;
    }

    @Override
    public T pop() {
        final T item = super.pop();
        minimums.pop();
        return item;
    }

    public T getMinimum() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return minimums.peek();
    }
}
