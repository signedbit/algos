package net.signedbit.fun.screening;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSearchTest {
    @Test
    void countNumbers() {
        assertEquals(0, SortedSearch.countNumbers(new int[]{}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{5}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{5, 6}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{4, 5}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{4, 4}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{4, 4, 4}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{4, 4, 4, 4}, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[]{4, 4, 4, 4, 5}, 4));
        assertEquals(1, SortedSearch.countNumbers(new int[]{3, 4, 4, 4, 5}, 4));
        assertEquals(2, SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
        assertEquals(3, SortedSearch.countNumbers(new int[]{1, 2, 2, 6}, 4));
        assertEquals(4, SortedSearch.countNumbers(new int[]{1, 2, 2, 2, 6}, 4));
        assertEquals(5, SortedSearch.countNumbers(new int[]{1, 2, 2, 2, 3}, 4));
    }
}