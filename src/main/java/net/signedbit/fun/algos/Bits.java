package net.signedbit.fun.algos;

public class Bits {
    public int insertion(final int N, final int M, final int i, final int j) {
        int n = clear(N, i, j);
        return n | (M << i);
    }

    private int clear(final int N, final int start, final int end) {
        final int length = end - start + 1;
        final int w = 32;
        final int mask = ~(((-1 << length) >>> (w - length)) << start);

        return N & mask;
    }

    public int flipBitToWin(final int N) {
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            final int bits = flipBitToWin(N, i, 1) + 1;
            max = Math.max(max, bits);
            if (max > i) {
                break;
            }
        }
        return max;
    }

    private int flipBitToWin(final int N, final int bitIndex, final int remaining) {
        if (bitIndex < 0 || remaining < 0) {
            return 0;
        }
        final boolean isSet = (N & 1 << bitIndex) != 0;
        if (isSet) {
            return 1 + flipBitToWin(N, bitIndex - 1, remaining);
        }
        return flipBitToWin(N, bitIndex - 1, remaining - 1);
    }

    public int nextNumberSuccessor(final int N) {
        for (int i = 0; i < 32; i++) {
            final boolean isSet = (N & 1 << i) != 0;
            final boolean isNextSet = (N & 1 << (i + 1)) != 0;
            if (isSet) {
                if (isNextSet) {
                    continue;
                }
                return swap(N, i, i + 1);
            }
        }
        throw new RuntimeException();
    }

    private int swap(final int N, final int index1, final int index2) {
        final int bit1 = (N & 1 << index1) != 0 ? 1 : 0;
        final int bit2 = (N & 1 << index2) != 0 ? 1 : 0;
        int result = N;
        result &= ~(1 << index1);
        result &= ~(1 << index2);
        result |= (bit1 << index2);
        result |= (bit2 << index1);
        return result;
    }

    public int conversion(final int A, final int B) {
        return conversion(A, B, 31);
    }

    private int conversion(final int A, final int B, final int bitIndex) {
        if (bitIndex < 0) {
            return 0;
        }
        final int mask = 1 << bitIndex;
        if (((A & mask) != 0) == ((B & mask) != 0)) {
            return conversion(A, B, bitIndex - 1);
        }
        return 1 + conversion(A, B, bitIndex - 1);
    }

    public int pairwiseSwap(final int N) {
        int result = N;
        for (int i = 0; i < 32; i += 2) {
            result = swap(result, i, i + 1);
        }
        return result;
    }
}
