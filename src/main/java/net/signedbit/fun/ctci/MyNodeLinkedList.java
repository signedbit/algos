package net.signedbit.fun.ctci;


public class MyNodeLinkedList<T> extends MyLinkedList<MyLinkedList.Node<T>> {
    @SafeVarargs
    public MyNodeLinkedList(final Node<T>... nodes) {
        super(nodes);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected MyLinkedList.Node newNode(final Object datum) {
        return (MyLinkedList.Node<T>) datum;
    }

    @Override
    protected Object data(final Node node) {
        return node;
    }
}
