package net.signedbit.fun.ctci;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedLists {
    /**
     * Time: O(n + n) = O(2n) = O(n)
     * Space: O(n)
     */
    public <T> MyLinkedList<T> removeDuplicates(final MyLinkedList<T> list) {
        final Set<T> items = new LinkedHashSet<>(list.getSize() / 2);
        for (final T s : list) {
            items.add(s);
        }
        final MyLinkedList<T> noDupes = new MyLinkedList<>();
        for (final T s : items) {
            noDupes.append(s);
        }
        return noDupes;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public <T> T kthToLast(final int k, final MyLinkedList<T> list) {
        if (list == null) {
            return null;
        }
        if (k < 0 || k >= list.getSize()) {
            return null;
        }


        return list.get(list.getSize() - k - 1);
    }

    /**
     * Time: O(2n) = O(n)
     * Space: O(1)
     */
    public <T> boolean deleteMiddleNode(final T element, final MyLinkedList<T> list) {
        if (list == null) {
            return false;
        }
        final int index = list.indexOf(element);
        if (index == 0 || index == list.getSize() - 1) {
            return false;
        }
        return list.remove(index) != null;
    }

    /**
     * Time: O(n + 1) = O(n)
     * Space: O(n)
     */
    public MyIntLinkedList partition(final int partition, final MyIntLinkedList list) {
        if (list == null) {
            return null;
        }
        return list.partition(partition);
    }

    /**
     * Time: O(m+n)
     * Space: O(m+n+1) = O(m+n)
     */
    public MyIntLinkedList sumListBackward(final MyIntLinkedList list1, final MyIntLinkedList list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        final int n1 = list1.covertToIntReverse();
        final int n2 = list2.covertToIntReverse();
        final MyIntLinkedList result = new MyIntLinkedList();
        int sum = n1 + n2;
        while (sum > 0) {
            result.append(sum % 10);
            sum /= 10;
        }
        return result;
    }

    /**
     * Time: O(m+n)
     * Space: O(m+n+1) = O(m+n)
     */
    public MyIntLinkedList sumListForward(final MyIntLinkedList list1, final MyIntLinkedList list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        final int n1 = list1.covertToIntForward();
        final int n2 = list2.covertToIntForward();
        final MyIntLinkedList result = new MyIntLinkedList();
        int sum = n1 + n2;
        while (sum > 0) {
            result.prepend(sum % 10);
            sum /= 10;
        }
        return result;
    }

    /**
     * Time: O(n/2) = O(n)
     * Space: O(1)
     */
    public <T> boolean isPalindrome(final MyLinkedList<T> list) {
        if (list == null) {
            return false;
        }
        return list.isPalindrome();
    }

    /**
     * Time: O(mn) = O(mn)
     * Space: O(m)
     *
     * Note: this compares by value, not reference because my impl doesn't consider the nodes to be first class
     */
    public <T> T intersection(final MyLinkedList<T> list1, final MyLinkedList<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        if (list1.isEmpty() || list2.isEmpty()) {
            return null;
        }

        final Set<T> seen = new HashSet<>(list1.getSize());
        list1.forEach(seen::add);
        for (final T item : list2) {
            if (seen.contains(item)) {
                return item;
            }
        }
        return null;
    }

    public <T> T hasLoop(final MyNodeLinkedList<T> list) {
        if (list == null) {
            return null;
        }

        MyNodeLinkedList.Node<T> finger1 = list.getFirst();
        MyNodeLinkedList.Node<T> finger2 = list.getFirst().next;

        while (finger1 != null && finger2 != null && finger2.next != null) {
            if (finger1 == finger2) {
                while (finger1.next.prev == finger1) {
                    finger1 = finger1.next;
                }
                return finger1.next.data;
            }

            finger1 = finger1.next;
            finger2 = finger2.next.next;
        }

        return null;
    }
}
