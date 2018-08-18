package net.signedbit.fun.screening;

import java.util.Arrays;

public class SortedSearch {
    /**
     * Given a sorted array, the goal is to determine how many elements in the array
     * are strictly less than a certain number.
     * <p>
     * Time: O(log n + n/2-1) = O(log n + n) = O(n), but O(log n) in many cases.
     * Space: O(1)
     */
    public static int countNumbers(int[] sortedArray, int key) {
        final int length = sortedArray.length;
        if (length == 0) {
            // no numbers, nothing can be < key
            return 0;
        }
        if (key <= sortedArray[0]) {
            // no numbers are less than key
            return 0;
        }
        if (key > sortedArray[length - 1]) {
            // everything is < key
            return length;
        }

        int insertionPoint = Arrays.binarySearch(sortedArray, key);
        if (insertionPoint < 0) {
            // From Arrays#binarySearch:
            //
            // "If the array contains multiple elements with the specified value,
            // there is no guarantee which one will be found."
            //
            // Therefore we must determine if we are at the beginning of the run.
            insertionPoint = -(insertionPoint + 1); // determine insertion point
        }

        // scan left for first instance of "key"
        for (int count = insertionPoint - 1; count >= 0; count--) {
            if (key != sortedArray[count]) {
                return count + 1;
            }
        }
        throw new RuntimeException("impossible");
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}
