package net.signedbit.fun.ctci;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements Iterable<T> {
    public static class Node<T> {
        protected Node<T> next;
        protected Node<T> prev;
        protected T data;

        public Node(final T data) {
            this.data = data;
        }
    }

    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    @SafeVarargs
    public MyLinkedList(final T... data) {
        for (final T datum : data) {
            append(datum);
        }
    }

    @SuppressWarnings("unchecked")
    protected Node<T> newNode(final Object datum) {
        return new Node<>((T) datum);
    }

    protected Object data(final Node<T> node) {
        if (node == null) {
            return null;
        }
        return node.data;
    }

    @SuppressWarnings("unchecked")
    private T dataOf(final Node<T> node) {
        return (T) data(node);
    }

    public void append(final T datum) {
        final Node<T> newNode = newNode(datum);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void prepend(final T datum) {
        final Node<T> newNode = newNode(datum);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T getFirst() {
        return dataOf(head);
    }

    public T getLast() {
        return dataOf(tail);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public T get(final int index) {
        if (size <= 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return dataOf(head);
        } else if (index == size - 1) {
            return dataOf(tail);
        } else {
            Node<T> n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return dataOf(n);
        }
    }

    public T remove(final int index) {
        if (size <= 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        if (index == 0) {
            final Node<T> oldHead = head;
            final Node<T> newHead = head.next;
            oldHead.next = null;
            if (newHead != null) {
                newHead.prev = null;
            }
            head = newHead;
            return dataOf(oldHead);
        } else if (index == size) {
            final Node<T> oldTail = tail;
            final Node<T> newTail = tail.prev;
            newTail.next = null;
            oldTail.prev = null;
            tail = newTail;
            return dataOf(oldTail);
        } else {
            Node<T> toRemove = head;
            for (int i = 0; i < index; i++) {
                toRemove = toRemove.next;
            }
            Node prev = toRemove.prev;
            Node next = toRemove.next;

            prev.next = next;
            next.prev = prev;
            toRemove.prev = null;
            toRemove.next = null;

            return dataOf(toRemove);
        }
    }

    public T remove(final T datum) {
        final int index = indexOf(datum);
        return remove(index);
    }

    public int indexOf(final T datum) {
        Node<T> n = head;
        for (int i = 0, size = getSize(); i < size; i++) {
            if (dataOf(n) == datum) {
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    public boolean contains(final T datum) {
        return indexOf(datum) != -1;
    }

    public boolean isPalindrome() {
        if (getSize() <= 1) {
            return true;
        }
        Node<T> first = head;
        Node<T> last = tail;
        while (first != last) {
            if (!Objects.equals(dataOf(first), dataOf(last))) {
                return false;
            }

            if (first.next == last) {
                return true;
            } else {
                first = first.next;
                last = last.prev;
            }
        }
        return Objects.equals(dataOf(first), dataOf(last));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> n = head;

            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            public T next() {
                final T data = dataOf(n);
                n = n.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        final Iterator<T> data = iterator();
        for (int i = Math.min(getSize(), 100); i >= 0 && data.hasNext(); i--) {
            sb.append(data.next());
            if (data.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        final Iterator<T> data = iterator();
        for (int num = 0, end = Math.min(getSize(), 100); num < end; ) {
            hashCode += num++;
            hashCode += data.next().hashCode();
        }
        return hashCode;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof MyLinkedList)) {
            return false;
        }
        final MyLinkedList<T> other = (MyLinkedList<T>) obj;
        if (getSize() != other.getSize()) {
            return false;
        }
        for (final Iterator<T> it = iterator(), otherIt = other.iterator(); it.hasNext(); ) {
            final T mine = it.next();
            final T theirs = otherIt.next();
            if (!mine.equals(theirs)) {
                return false;
            }
        }
        return true;
    }
}
