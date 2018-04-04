package net.signedbit.fun.ctci;

public interface IStack<T> {
    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();

    int getHeight();
}
