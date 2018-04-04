package net.signedbit.fun.algos;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicProgrammingTest {
    private DynamicProgramming clz = new DynamicProgramming();

    @Test
    void tripleStep() {
        assertEquals(1, clz.tripleStep(1));
        assertEquals(2, clz.tripleStep(2));
        assertEquals(4, clz.tripleStep(3));
        assertEquals(7, clz.tripleStep(4));
        assertEquals(13, clz.tripleStep(5));
    }

    @Test
    void magicIndex() {
        assertEquals(1, clz.magicIndex(new int[]{-1, 1, 3}));
        assertEquals(1, clz.magicIndex(new int[]{-1, 1, 2}));
    }

    @Test
    void subsets() {
        assertArrayEquals(new int[][]{
                {},
                {0},
                {1},
                {2},
                {1, 2},
                {0, 1},
                {0, 2},
                {0, 1, 2}
        }, clz.subsets(new Integer[]{0, 1, 2}));
        assertArrayEquals(new int[][]{
                {},
                {0},
                {1},
                {0, 1},
        }, clz.subsets(new Integer[]{0, 1}));
    }

    @Test
    void recursiveMultiply() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                assertEquals(i * j, clz.recursiveMultiply(i, j));
            }
        }
    }

    @Test
    void towersOfHanoi() {
        assertEquals("p1->p2", clz.towersOfHanoi(1));
        assertEquals("p1->p3 p1->p2 p3->p2", clz.towersOfHanoi(2));
        assertEquals("p1->p2 p1->p3 p2->p3 p1->p2 p3->p1 p3->p2 p1->p2", clz.towersOfHanoi(3));
    }

    @Test
    void permWithoutDups() {
        assertEquals(null, clz.permWithoutDups(null));
        assertEquals(ImmutableSet.of("a"), clz.permWithoutDups("a"));
        assertEquals(ImmutableSet.of("ab", "ba"), clz.permWithoutDups("ab"));
        assertEquals(ImmutableSet.of("abc", "acb", "bac", "bca", "cab", "cba"), clz.permWithoutDups("abc"));
    }

    @Test
    void permWithoutDups2() {
        assertEquals(null, clz.permWithoutDups2(null));
        assertEquals(ImmutableSet.of("a"), clz.permWithoutDups2("a"));
        assertEquals(ImmutableSet.of("ab", "ba"), clz.permWithoutDups2("ab"));
        assertEquals(ImmutableSet.of("abc", "acb", "bac", "bca", "cba", "cab"), clz.permWithoutDups2("abc"));
    }

    @Test
    void permWithDups() {
        assertEquals(null, clz.permWithDups(null));
        assertEquals(ImmutableSet.of("a"), clz.permWithDups("a"));
        assertEquals(ImmutableSet.of("aa"), clz.permWithDups("aa"));
        assertEquals(ImmutableSet.of("aab", "aba", "baa"), clz.permWithDups("aab"));
        assertEquals(ImmutableSet.of("abc", "acb", "bac", "bca", "cab", "cba"), clz.permWithDups("abc"));
    }

    @Test
    void parens() {
        assertEquals(ImmutableSet.of(), clz.parens(0));
        assertEquals(ImmutableSet.of("()"), clz.parens(1));
        assertEquals(ImmutableSet.of("()()", "(())"), clz.parens(2));
        assertEquals(ImmutableSet.of("()()()", "()(())", "(()())", "((()))", "(())()"), clz.parens(3));
    }

    @Test
    void paintFill() {
        assertArrayEquals(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        }, clz.paintFill(1, 2, 2, new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        }));

        assertArrayEquals(new int[][]{
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 2},
        }, clz.paintFill(2, 2, 2, new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        }));

        assertArrayEquals(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        }, clz.paintFill(0, 1, 1, new int[][]{
                {1, 1, 1},
                {1, 3, 1},
                {1, 1, 1},
        }));
    }

    @Test
    void coins() {
//        assertEquals(1, clz.coins(1));
//        assertEquals(1, clz.coins(2));
//        assertEquals(1, clz.coins(3));
//        assertEquals(1, clz.coins(4));
//        assertEquals(2, clz.coins(5));
//        assertEquals(2, clz.coins(6));
//        assertEquals(4, clz.coins(10));
//        assertEquals(4, clz.coins(11));
//        assertEquals(2, clz.coins(12));
//        assertEquals(2, clz.coins(25));
//        assertEquals(2, clz.coins(50));
//        assertEquals(2, clz.coins(100));

//        System.out.println(clz.coins2(25, 3));
//        for (int i = 0; i < 1000000; i++) {
//            final int expected = clz.coins2(i, 3);
//            final int actual = clz.coins(i);
//            System.out.println(i +  " expected=" + expected + " actual=" + actual);
//            assertEquals(expected, actual);
//        }
    }
}