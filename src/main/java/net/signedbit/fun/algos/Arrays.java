package net.signedbit.fun.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Arrays {
    /**
     * Time: O(n)
     * Space: O(n/2) = O(n)
     */
    public boolean isUnique(final String s) {
        if (s == null) {
            return true;
        }
        final Set<Character> chars = new HashSet<>(s.length() / 2);
        for (final char chr : s.toCharArray()) {
            if (chars.contains(chr)) {
                return false;
            }
            chars.add(chr);
        }
        return true;
    }

    /**
     * Time: O(3*n) = O(n)
     * Space: O(2n) = O(n)
     */
    public boolean isPermutation(final String s1, final String s2) {
        if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }

        final Map<Character, Integer> counts1 = countChars(s1);
        final Map<Character, Integer> counts2 = countChars(s2);

        return counts1.equals(counts2);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private Map<Character, Integer> countChars(final String s) {
        final Map<Character, Integer> counts = new HashMap<>(s.length());
        for (final char chr : s.toCharArray()) {
            counts.put(chr, counts.getOrDefault(chr, 0) + 1);
        }
        return counts;
    }

    /**
     * Time: O(n + n*n) = O(n^2)
     * Space: O(n)
     */
    public String urlify(final String s, final int finalLength) {
        final char[] url = new char[finalLength];

        // copy
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            url[i] = chars[i];
        }

        for (int i = 0; i < url.length; i++) {
            final char c = url[i];
            if (c != ' ') {
                continue;
            }

            shift(url, i, 2);
            url[i++] = '%';
            url[i++] = '2';
            url[i] = '0';
        }
        return new String(url);
    }


    /**
     * Time: O(n)
     * Space: O(1)
     */
    private void shift(final char[] chars, final int start, final int length) {
        for (int i = chars.length - length; i > start; i--) {
            chars[i + 1] = chars[(i - length) + 1];
        }
    }

    /**
     * Time: O(3n) = O(n)
     * Space: O(n)
     */
    public boolean isPalindromePermutation(final String s) {
        if (s == null) {
            return false;
        }
        final Map<Character, Integer> counts = countChars(s.toLowerCase());
        counts.remove(' ');
        int odds = 0;
        for (final int count : counts.values()) {
            if (count % 2 != 0) {
                odds++;
            }
        }
        return odds <= 1;
    }


    /**
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isOneAway(final String base, final String goal) {
        if (base == null || goal == null) {
            return false;
        }
        return isOneAway(base, goal, 1);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private boolean isOneAway(final String base, final String goal, final int remainingEdits) {
        if (remainingEdits < 0 || Math.abs(goal.length() - base.length()) > remainingEdits) {
            return false;
        }
        if (base.equals(goal) || base.length() == 0 || goal.length() == 0) {
            return true;
        }
        if (base.charAt(0) == goal.charAt(0)) {
            return isOneAway(base.substring(1), goal.substring(1), remainingEdits);
        }
        return isOneAway(goal.charAt(0) + base, goal, remainingEdits - 1) ||
                isOneAway(base.substring(1), goal, remainingEdits - 1) ||
                isOneAway(goal.charAt(0) + base.substring(1), goal, remainingEdits - 1);
    }

    /**
     * Time: O(n + n.amor) = O(n + 1) = O(n) amortized
     * Space: O(2n) = O(n)
     */
    public String compress(final String in) {
        if (in == null) {
            return null;
        }
        final int n = in.length();
        final StringBuilder out = new StringBuilder(n);
        final char[] chars = in.toCharArray();
        for (int i = 0; i < n; ) {
            final char startChar = chars[i];
            final int runLength = runLength(chars, startChar, i);
            out.append(startChar);
            out.append(runLength);
            i += runLength;
        }
        final String compressed = out.toString();
        return compressed.length() < in.length() ? compressed : in;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private int runLength(final char[] chars, final char key, final int startIdx) {
        int length = 0;
        for (int i = startIdx; i < chars.length; i++) {
            if (chars[i] == key) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public int[][] rotateMatrix(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        // x, y -> y, -x
        final int n = matrix.length;
        final int[][] rotated = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotated[col][(n - row) - 1] = matrix[row][col];
            }
        }
        return rotated;
    }

    /**
     * Time: O(3n^2) = O(n^2)
     * Space: O(2n) = O(n)
     */
    public int[][] zeroMatrix(final int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        final int n = matrix.length;
        final Set<Integer> rows = new HashSet<>();
        final Set<Integer> cols = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        for (final int row : rows) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
        for (final int col : cols) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    /**
     * Time: O(n) or O(n^2) if isSubstring is n*n
     * Space: O(n^2 + n) = O(n^2);
     */
    public boolean isRotated(final String rotated, final String original) {
        if (rotated == null || original == null) {
            return false;
        }

        final int n = original.length();
        final StringBuilder sb = new StringBuilder(n * n + n);

        for (int i = 1; i < n; i++) {
            sb.append(original.substring(i));
            sb.append(original.substring(0, i));
            sb.append(' ');
        }

        return isSubstring(rotated, sb.toString());
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private boolean isSubstring(final String sub, final String supr) {
        return supr.contains(sub);
    }
}
