package net.signedbit.fun.algos;

import net.signedbit.fun.ctci.MyStack;

public class Stacks {
    public <T extends Comparable<T>> MyStack<T> sort(final MyStack<T> stack) {
        if (stack == null) {
            return null;
        }

        final MyStack<T> sorted = new MyStack<>();
        sorted.push(stack.pop());

        while(!stack.isEmpty()) {
            final T next = stack.pop();

            final MyStack<T> temp = new MyStack<>();

            while (!sorted.isEmpty() && next.compareTo(sorted.peek()) > 0) {
                temp.push(sorted.pop());
            }

            sorted.push(next);

            while (!temp.isEmpty()) {
                sorted.push(temp.pop());
            }
        }

        return sorted;
    }
}
