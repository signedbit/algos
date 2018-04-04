package net.signedbit.fun.ctci;

public class MyIntLinkedList extends MyLinkedList<Integer> {
    public MyIntLinkedList(final int... data) {
        for (final int datum : data) {
            append(datum);
        }
    }

    public MyIntLinkedList partition(final int partition) {
        final MyIntLinkedList left = new MyIntLinkedList();
        final MyIntLinkedList right = new MyIntLinkedList();

        Node<Integer> n = head;
        while (n != null) {
            final int data = n.data;
            if (data < partition) {
                left.append(data);
            } else {
                right.append(data);
            }
            n = n.next;
        }

        if (left.isEmpty()) {
            return right;
        }
        if (right.isEmpty()) {
            return left;
        }

        left.tail.next = right.head;
        right.head.prev = left.tail;
        left.tail = right.tail;
        left.size += right.size;
        return left;
    }

    public int covertToIntReverse() {
        int result = 0;
        int power = 1;
        for (final int i : this) {
            result += power * i;
            power *= 10;
        }
        return result;
    }

    public int covertToIntForward() {
        int result = 0;
        int power = 1;
        Node<Integer> n = tail;
        while (n != null) {
            result += power * n.data;
            power *= 10;
            n = n.prev;
        }
        return result;
    }
}
