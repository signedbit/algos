package net.signedbit.fun.screening;

import java.util.Arrays;

public class SortedSearch {
    /**
     * Given a sorted array, the goal is to determine how many elements in the array
     * are strictly less than a certain number.
     *
     * Time: O(log n)
     * Space: O(1)
     */
    public static int countNumbers(int[] sortedArray, int lessThan) {
        final int index = Arrays.binarySearch(sortedArray, lessThan);
        if (index < 0) {
            return -(index + 1);
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}
