package net.signedbit.fun.ctci;

import java.util.NoSuchElementException;

public class MyStack<T> implements IStack<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    public MyStack(final T... data) {
        for (final T datum : data) {
            push(datum);
        }
    }

    @Override
    public void push(final T item) {
        list.prepend(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return list.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getHeight() {
        return list.getSize();
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof MyStack)) {
            return false;
        }
        return list.equals(((MyStack) obj).list);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
