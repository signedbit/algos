package net.signedbit.fun.ctci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class SetOfStacks<T> implements IStack<T> {
    private final int stackCapacity;
    private final ArrayList<MyStack<T>> stacks;

    private int totalHeight;

    public SetOfStacks(final int stackCapacity) {
        this.stackCapacity = stackCapacity;

        this.stacks = new ArrayList<>(Collections.singleton(new MyStack<T>()));
    }


    public void push(final T item) {
        MyStack<T> stack = stacks.get(stacks.size() - 1);
        if (stack.getHeight() == stackCapacity) {
            stack = new MyStack<>();
            stacks.add(stack);
        }
        stack.push(item);
        totalHeight++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        final MyStack<T> stack = stacks.get(stacks.size() - 1);
        final T result = stack.pop();
        if (stack.isEmpty() && stacks.size() > 1) {
            stacks.remove(stacks.size() - 1);
        }
        totalHeight--;
        return result;
    }

    public T popAt(final int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        final MyStack<T> stack = stacks.get(index);
        final T result = stack.pop();
        if (stack.isEmpty() && stacks.size() > 1) {
            stacks.remove(stack);
        }
        totalHeight--;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return stacks.get(stacks.size() - 1).peek();
    }

    public boolean isEmpty() {
        return getHeight() == 0;
    }

    public int getHeight() {
        return totalHeight;
    }

}
