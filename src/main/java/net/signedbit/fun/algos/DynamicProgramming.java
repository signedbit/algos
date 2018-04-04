package net.signedbit.fun.algos;

import com.google.common.collect.*;
import com.google.common.math.IntMath;

import java.util.*;

public class DynamicProgramming {
    public int tripleStep(final int steps) {
        final int[] memo = new int[steps + 1];
        return tripleStep(steps, memo);
    }

    private int tripleStep(final int steps, final int[] memo) {
        if (steps <= 0) {
            return 0;
        }
        if (steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        if (steps == 3) {
            return 4;
        }
        if (memo[steps] == 0) {
            memo[steps] = tripleStep(steps - 1, memo) + tripleStep(steps - 2, memo) + tripleStep(steps - 3, memo);
        }
        return memo[steps];

    }

    public int magicIndex(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            final int value = array[i];
            if (value == i) {
                return i;
            }
            if (value > i) {
                i = value - 1;
            }
        }
        return -1;
    }

    public int[][] subsets(final Integer[] set) {
        final int n = set.length;
        final List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(Collections.emptyList());
        subsets.addAll(subsets(set, 0));
        final int[][] sets = new int[subsets.size()][];
        for (int i = 0; i < subsets.size(); i++) {
            final List<Integer> subset = subsets.get(i);
            final Integer[] integerSubset = subset.toArray(new Integer[subset.size()]);
            final int[] sub = new int[integerSubset.length];
            for (int j = 0; j < integerSubset.length; j++) {
                sub[j] = integerSubset[j];
            }
            sets[i] = sub;

        }
        return sets;
    }

    private List<List<Integer>> subsets(final Integer[] set, final int startIndex) {
        if (startIndex >= set.length) {
            return Collections.emptyList();
        }

        final List<List<Integer>> subsets = subsets(set, startIndex + 1);
        final List<List<Integer>> result = new ArrayList<>(subsets.size() + 1);
        final Integer item = set[startIndex];
        result.add(Collections.singletonList(item));
        result.addAll(subsets);
        for (final List<Integer> subset : subsets) {
            final List<Integer> next = new ArrayList<>(subset.size() + 1);
            next.add(item);
            next.addAll(subset);
            result.add(next);
        }
        return result;
    }

    public int recursiveMultiply(final int a, final int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }

        return a + recursiveMultiply(a, b - 1);
    }

    public String towersOfHanoi(final int disks) {
        return towersOfHanoi(disks, "p1", "p2", "p3");
    }

    private String towersOfHanoi(final int disks,
                                 final String source,
                                 final String dest,
                                 final String aux) {
        String moves = "";
        if (disks == 1) {
            moves += source + "->" + dest;
        } else {
            moves += towersOfHanoi(disks - 1, source, aux, dest);
            moves += " " + source + "->" + dest;
            moves += " " + towersOfHanoi(disks - 1, aux, dest, source);
        }
        return moves;
    }

    public Set<String> permWithoutDups(final String string) {
        if (string == null) {
            return null;
        }
        return ImmutableSet.copyOf(permute(HashMultiset.create(Lists.charactersOf(string))));
    }

    public ImmutableSet<String> permWithDups(final String string) {
        if (string == null) {
            return null;
        }
        final Multiset<Character> set = HashMultiset.create(Lists.charactersOf(string));
        return ImmutableSet.copyOf(permute(set));
    }

    private Set<String> permute(final Multiset<Character> set) {
        final int n = set.size();
        if (n == 0) {
            return ImmutableSet.of("");
        }
        final Set<String> result = new LinkedHashSet<>(IntMath.factorial(n));
        for (final char c : set) {
            for (final String permutation : permute(Multisets.difference(set, ImmutableMultiset.of(c)))) {
                result.add(c + permutation);
            }
        }
        return result;
    }

    public Set<String> permWithoutDups2(final String string) {
        if (string == null) {
            return null;
        }
        final Set<String> result = new HashSet<>(IntMath.factorial(string.length()));
        permWithoutDups2(result, string.toCharArray(), 0);
        return result;
    }

    private void permWithoutDups2(final Set<String> result, final char[] array, final int start) {
        final int n = array.length - 1;

        if (start == n) {
            result.add(new String(array));
            return;
        }

        for (int i = start; i <= n; i++) {
            swap(array, i, start);
            permWithoutDups2(result, array, start + 1);
            swap(array, i, start);
        }
    }

    private void swap(final char[] array, final int index1, final int index2) {
        final char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public ImmutableSet<String> parens(final int pairs) {
        if (pairs == 0) {
            return ImmutableSet.of();
        }
        if (pairs == 1) {
            return ImmutableSet.of("()");
        }
        final Set<String> result = new HashSet<>();
        for (final String paren : parens(pairs - 1)) {
            result.add("(" + paren + ")");
            result.add("()" + paren);
            result.add(paren + "()");
        }
        return ImmutableSet.copyOf(result);
    }

    public int[][] paintFill(final int color, final int row, final int col, final int[][] pixels) {
        final int old = pixels[row][col];
        if (old == color) {
            return pixels;
        }
        paintFill(color, old, row, col, pixels);
        return pixels;
    }

    private void paintFill(final int color, final int old, final int row, final int col, final int[][] pixels) {
        if (row < 0 || col < 0) {
            return;
        }

        if (row >= pixels.length || col >= pixels[row].length) {
            return;
        }

        if (pixels[row][col] != old) {
            return;
        }

        pixels[row][col] = color;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                paintFill(color, old, row + i, col + j, pixels);
            }
        }
    }

    public int coins(final int cents) {
        final int[] memo = new int[cents + 1];
        return coins(cents, memo);
    }

    private int coins(final int cents, final int[] memo) {
        if (cents < 0) {
            return 0;
        }

        if (memo[cents] != 0) {
            return memo[cents];
        }

        final int ways;
        if (cents <= 4) {
            ways = 1;
            // 1
            // 1 + 1
            // 1 + 1 + 1
            // 1 + 1 + 1 + 1
        } else if (cents <= 9) {
            ways = 2;
            // 5
            // 5 + 1
            // 5 + 1 + 1
            // 5 + 1 + 1 + 1
            // 5 + 1 + 1 + 1 + 1
        } else if (cents == 10) {
            ways = 4;
            // 10
            // 5 + 5
            // (1 + 1 + 1 + 1 + 1) + 5
            // (1 + 1 + 1 + 1 + 1) + (1 + 1 + 1 + 1 + 1)
        } else if (cents == 25) {
            // ((1+1+1+1+1)+(1+1+1+1+1))+((1+1+1+1+1)+(1+1+1+1+1))+(1+1+1+1+1)
            // (5+(1+1+1+1+1))+((1+1+1+1+1)+(1+1+1+1+1))+(1+1+1+1+1)
            // (5+5)+((1+1+1+1+1)+(1+1+1+1+1))+(1+1+1+1+1)
            // (5+5)+(5+(1+1+1+1+1))+(1+1+1+1+1)
            // (5+5)+(5+5)+(1+1+1+1+1)
            // (5+5)+(5+5)+5
            // 10+10+5
            // 10+5+(5+5)
            // 10+5+5+(1+1+1+1+1)
            // 10+5+((1+1+1+1+1)+(1+1+1+1+1))
            // 10+((1+1+1+1+1)+(1+1+1+1+1))+(1+1+1+1+1)
            // 10+10+(1+1+1+1+1)
            // 25
            return 13;
        } else {
            // 1 + 10
            // 1 + 5 + 5
            // 1 + (1+1+1+1+1) + (1+1+1+1+1)

            final int nickels = cents / 5;
            final int dime = cents / 10;
            final int quarters = cents / 25;

            int way = 1;
            if (quarters > 0) {
                way += quarters + coins(cents - (quarters * 25));
            }
            if (dime > 0) {
                way += dime + coins(cents - (dime * 10));
            }
            if (nickels > 0) {
                way += nickels + coins(cents - (nickels * 5));
            }
            ways = way;
        }

        memo[cents] = ways;

        return memo[cents];
    }


    final int[] C = {1, 5, 10, 25};

    public int coins2(final int n, final int k) {
        {
            final int[][] table = new int[n + 1][k + 1];
            for (final int[] row : table) {
                java.util.Arrays.fill(row, 1);
            }

            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= k; ++j) {
                    if (i < 0 || j < 0) { // Impossible, for illustration purpose
                        table[i][j] = 0;
                    } else if (i == 0 || j == 0) { // Very Important
                        table[i][j] = 1;
                    } else {
                        // The recursion. Be careful with the vector boundary
                        table[i][j] = table[i][j - 1] +
                                (i < C[j] ? 0 : table[i - C[j]][j]);
                    }
                }
            }

            return table[n][k];
        }

    }
}
