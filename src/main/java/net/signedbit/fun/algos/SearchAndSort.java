package net.signedbit.fun.algos;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchAndSort {
    public int rankFromStream(final int[] stream, final int number) {
        final Multiset<Integer> multiset = HashMultiset.create();

        Arrays.stream(stream).forEach(multiset::add);

        return IntStream.range(0, number).map(multiset::count).sum();
    }
}
