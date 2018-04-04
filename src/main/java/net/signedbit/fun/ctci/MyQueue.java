package net.signedbit.fun.ctci;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private final IStack<T> stack1 = new MyStack<>();
    private final IStack<T> stack2 = new MyStack<>();

    public void push(final T item) {
        stack1.push(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        drainTo(stack1, stack1.getHeight() - 1, stack2);
        final T result = stack1.pop();
        drainTo(stack2, stack2.getHeight(), stack1);
        return result;
    }

    private void drainTo(final IStack<T> source, final int count, final IStack<T> dest) {
        for (int i = 0; i < count; i++) {
            dest.push(source.pop());
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        drainTo(stack1, stack1.getHeight() - 1, stack2);
        final T result = stack1.peek();
        drainTo(stack2, stack2.getHeight(), stack1);

        return result;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int getHeight() {
        return stack1.getHeight();
    }
}
