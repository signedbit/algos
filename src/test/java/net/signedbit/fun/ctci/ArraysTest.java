package net.signedbit.fun.ctci;

import net.signedbit.fun.algos.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    @Test
    void isUnique() {
        assertTrue(new Arrays().isUnique("a"));
        assertTrue(new Arrays().isUnique(""));
        assertTrue(new Arrays().isUnique(null));
        assertTrue(new Arrays().isUnique("ab"));
        assertTrue(new Arrays().isUnique("abc"));
        assertFalse(new Arrays().isUnique("aa"));
        assertFalse(new Arrays().isUnique("aab"));
        assertFalse(new Arrays().isUnique("abbc"));
        assertFalse(new Arrays().isUnique("abcc"));
    }

    @Test
    void isPermutation() {
        assertTrue(new Arrays().isPermutation("", ""));
        assertTrue(new Arrays().isPermutation("a", "a"));
        assertTrue(new Arrays().isPermutation("ab", "ab"));
        assertTrue(new Arrays().isPermutation("ab", "ba"));
        assertTrue(new Arrays().isPermutation("abc", "cba"));
        assertTrue(new Arrays().isPermutation("abc", "cab"));
        assertFalse(new Arrays().isPermutation(null, null));
        assertFalse(new Arrays().isPermutation(null, "a"));
        assertFalse(new Arrays().isPermutation("a", null));
        assertFalse(new Arrays().isPermutation("abc", "abcd"));
        assertFalse(new Arrays().isPermutation("", "a"));
    }

    @Test
    void urlify() {
        assertEquals("", new Arrays().urlify("", 0));
        assertEquals("Hi", new Arrays().urlify("Hi", 2));
        assertEquals("H%20i", new Arrays().urlify("H i", 5));
        assertEquals("%20i", new Arrays().urlify(" i", 4));
        assertEquals("H%20", new Arrays().urlify("H ", 4));
        assertEquals("Mr%20John%20Smith", new Arrays().urlify("Mr John Smith", 17));
    }

    @Test
    void isPalindromePermutation() {
        assertTrue(new Arrays().isPalindromePermutation(""));
        assertTrue(new Arrays().isPalindromePermutation("a"));
        assertTrue(new Arrays().isPalindromePermutation("aba"));
        assertTrue(new Arrays().isPalindromePermutation("aab"));
        assertTrue(new Arrays().isPalindromePermutation("Tact Coa"));
        assertTrue(new Arrays().isPalindromePermutation("Racecar"));
        assertTrue(new Arrays().isPalindromePermutation("Racecra"));
        assertTrue(new Arrays().isPalindromePermutation("Raccar"));
        assertTrue(new Arrays().isPalindromePermutation("Ractcar"));
        assertTrue(new Arrays().isPalindromePermutation("Ractcra"));
        assertFalse(new Arrays().isPalindromePermutation(null));
        assertFalse(new Arrays().isPalindromePermutation("ab"));
        assertFalse(new Arrays().isPalindromePermutation("Taco"));
        assertFalse(new Arrays().isPalindromePermutation("Tacoca"));
    }

    @Test
    void isOneAway() {
        assertTrue(new Arrays().isOneAway("pale", "ple"));
        assertTrue(new Arrays().isOneAway("pales", "pale"));
        assertTrue(new Arrays().isOneAway("pale", "pales"));
        assertTrue(new Arrays().isOneAway("pale", "bale"));
        assertFalse(new Arrays().isOneAway(null, "pale"));
        assertFalse(new Arrays().isOneAway("pale", null));
        assertFalse(new Arrays().isOneAway(null, null));
        assertFalse(new Arrays().isOneAway("pale", "bake"));
    }

    @Test
    void compress() {
        assertEquals(null, new Arrays().compress(null));
        assertEquals("a2b1c5a3", new Arrays().compress("aabcccccaaa"));
        assertEquals("a", new Arrays().compress("a"));
        assertEquals("abb", new Arrays().compress("abb"));
        assertEquals("abbcc", new Arrays().compress("abbcc"));
        assertEquals("abbccc", new Arrays().compress("abbccc"));
        assertEquals("a1b2c4", new Arrays().compress("abbcccc"));
    }

    @Test
    void rotateMatrix() {
        assertEquals(null, new Arrays().rotateMatrix(null));
//        assertEquals(null, new Arrays().rotateMatrix(new int[1][2]));
        assertArrayEquals(new int[][]{{3, 2}, {4, 1}}, new Arrays().rotateMatrix(new int[][]{
                {2, 1},
                {3, 4}
        }));
    }

    @Test
    void zeroMatrix() {
        assertEquals(null, new Arrays().rotateMatrix(null));
        assertArrayEquals(new int[][]{{2, 1, 2}, {3, 4, 12}, {4, 45, 20}}, new Arrays().zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 4, 12},
                {4, 45, 20}
        }));
        assertArrayEquals(new int[][]{{2, 0, 2}, {0, 0, 0}, {4, 0, 20}}, new Arrays().zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 0, 12},
                {4, 45, 20}
        }));
        assertArrayEquals(new int[][]{{0, 1, 2}, {0, 4, 12}, {0, 0, 0}}, new Arrays().zeroMatrix(new int[][]{
                {2, 1, 2},
                {3, 4, 12},
                {0, 5, 20}
        }));
    }

    @Test
    void isRotated() {
        assertTrue(new Arrays().isRotated("erbottlewat", "waterbottle"));
        assertTrue(new Arrays().isRotated("rbottlewate", "waterbottle"));
        assertTrue(new Arrays().isRotated("ewaterbottl", "waterbottle"));
        assertFalse(new Arrays().isRotated(null, "waterbottle"));
        assertFalse(new Arrays().isRotated("erbottlewat", null));
        assertFalse(new Arrays().isRotated(null, null));

    }
}