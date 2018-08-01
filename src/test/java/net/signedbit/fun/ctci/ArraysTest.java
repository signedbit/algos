package net.signedbit.fun.ctci;

import net.signedbit.fun.algos.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    private final Arrays arrays = new Arrays();

    @Test
    void isUnique() {
        assertTrue(arrays.isUnique("a"));
        assertTrue(arrays.isUnique(""));
        assertTrue(arrays.isUnique(null));
        assertTrue(arrays.isUnique("ab"));
        assertTrue(arrays.isUnique("abc"));
        assertFalse(arrays.isUnique("aa"));
        assertFalse(arrays.isUnique("aab"));
        assertFalse(arrays.isUnique("abbc"));
        assertFalse(arrays.isUnique("abcc"));
    }

    @Test
    void isPermutation() {
        assertTrue(arrays.isPermutation("", ""));
        assertTrue(arrays.isPermutation("a", "a"));
        assertTrue(arrays.isPermutation("ab", "ab"));
        assertTrue(arrays.isPermutation("ab", "ba"));
        assertTrue(arrays.isPermutation("abc", "cba"));
        assertTrue(arrays.isPermutation("abc", "cab"));
        assertFalse(arrays.isPermutation(null, null));
        assertFalse(arrays.isPermutation(null, "a"));
        assertFalse(arrays.isPermutation("a", null));
        assertFalse(arrays.isPermutation("abc", "abcd"));
        assertFalse(arrays.isPermutation("", "a"));
    }

    @Test
    void urlify() {
        assertEquals("", arrays.urlify("", 0));
        assertEquals("Hi", arrays.urlify("Hi", 2));
        assertEquals("H%20i", arrays.urlify("H i", 5));
        assertEquals("%20i", arrays.urlify(" i", 4));
        assertEquals("H%20", arrays.urlify("H ", 4));
        assertEquals("Mr%20John%20Smith", arrays.urlify("Mr John Smith", 17));
    }

    @Test
    void isPalindromePermutation() {
        assertTrue(arrays.isPalindromePermutation(""));
        assertTrue(arrays.isPalindromePermutation("a"));
        assertTrue(arrays.isPalindromePermutation("aba"));
        assertTrue(arrays.isPalindromePermutation("aab"));
        assertTrue(arrays.isPalindromePermutation("Tact Coa"));
        assertTrue(arrays.isPalindromePermutation("Racecar"));
        assertTrue(arrays.isPalindromePermutation("Racecra"));
        assertTrue(arrays.isPalindromePermutation("Raccar"));
        assertTrue(arrays.isPalindromePermutation("Ractcar"));
        assertTrue(arrays.isPalindromePermutation("Ractcra"));
        assertFalse(arrays.isPalindromePermutation(null));
        assertFalse(arrays.isPalindromePermutation("ab"));
        assertFalse(arrays.isPalindromePermutation("Taco"));
        assertFalse(arrays.isPalindromePermutation("Tacoca"));
    }

    @Test
    void isOneAway() {
        assertTrue(arrays.isOneAway("pale", "ple"));
        assertTrue(arrays.isOneAway("pales", "pale"));
        assertTrue(arrays.isOneAway("pale", "pales"));
        assertTrue(arrays.isOneAway("pale", "bale"));
        assertFalse(arrays.isOneAway(null, "pale"));
        assertFalse(arrays.isOneAway("pale", null));
        assertFalse(arrays.isOneAway(null, null));
        assertFalse(arrays.isOneAway("pale", "bake"));
    }

    @Test
    void compress() {
        assertEquals(null, arrays.compress(null));
        assertEquals("a2b1c5a3", arrays.compress("aabcccccaaa"));
        assertEquals("a", arrays.compress("a"));
        assertEquals("abb", arrays.compress("abb"));
        assertEquals("abbcc", arrays.compress("abbcc"));
        assertEquals("abbccc", arrays.compress("abbccc"));
        assertEquals("a1b2c4", arrays.compress("abbcccc"));
    }

    @Test
    void rotateMatrix() {
        assertNull(arrays.rotateMatrix(null));
        assertArrayEquals(new int[][]{{3, 2}, {4, 1}}, arrays.rotateMatrix(new int[][]{
                {2, 1},
                {3, 4}
        }));
    }

    @Test
    void zeroMatrix() {
        assertNull(arrays.zeroMatrix(null));

        // case 1: no rows or cols are zeroed
        int[][] expected = {
                {2, 1, 2},
                {3, 4, 12},
                {4, 45, 20}
        };
        int[][] actual = arrays.zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 4, 12},
                {4, 45, 20}
        });
        assertArrayEquals(expected, actual);


        // case 2: the center row and column is zeroed
        expected = new int[][]{
                {2, 0, 2},
                {0, 0, 0},
                {4, 0, 20}
        };
        actual = arrays.zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 0, 12},
                {4, 45, 20}
        });
        assertArrayEquals(expected, actual);


        // case 3: a non-center row and column is zeroed
        expected = new int[][]{
                {0, 1, 2},
                {0, 4, 12},
                {0, 0, 0}
        };
        actual = arrays.zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 4, 12},
                {0, 5, 20}
        });
        assertArrayEquals(expected, actual);
    }

    @Test
    void isRotated() {
        assertTrue(arrays.isRotated("erbottlewat", "waterbottle"));
        assertTrue(arrays.isRotated("rbottlewate", "waterbottle"));
        assertTrue(arrays.isRotated("ewaterbottl", "waterbottle"));
        assertFalse(arrays.isRotated(null, "waterbottle"));
        assertFalse(arrays.isRotated("erbottlewat", null));
        assertFalse(arrays.isRotated(null, null));
    }
}