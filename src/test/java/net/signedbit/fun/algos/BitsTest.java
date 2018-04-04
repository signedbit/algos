package net.signedbit.fun.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitsTest {
    @Test
    void insertion() {
        assertEquals(0b1100, new Bits().insertion(0b1011, 0b100, 0, 2));
        assertEquals(0b10001001100, new Bits().insertion(0b10000000000, 0b10011, 2, 6));
        assertEquals(0b11111111, new Bits().insertion(0b11100001, 0b1111, 1, 4));
        assertEquals(0b100010000, new Bits().insertion(0b100010000, 0b1, 4, 4));
    }

    @Test
    void flipBitToWin() {
        assertEquals(8, new Bits().flipBitToWin(0b11011101111));
        assertEquals(1, new Bits().flipBitToWin(0b0));
        assertEquals(3, new Bits().flipBitToWin(0b0101010101));
        assertEquals(9, new Bits().flipBitToWin(0b111011111));
        assertEquals(9, new Bits().flipBitToWin(0b111111110));
        assertEquals(9, new Bits().flipBitToWin(0b011111111));
        assertEquals(10, new Bits().flipBitToWin(0b111111111));
    }

    @Test
    void nextNumberSuccessor() {
        assertEquals(0b10, new Bits().nextNumberSuccessor(0b1));
        assertEquals(0b100, new Bits().nextNumberSuccessor(0b10));
        assertEquals(0b1000, new Bits().nextNumberSuccessor(0b100));

        assertEquals(0b101, new Bits().nextNumberSuccessor(0b11));
        assertEquals(0b110, new Bits().nextNumberSuccessor(0b101));
//        assertEquals(0b1001, new Bits().nextNumberSuccessor(0b110));

        assertEquals(0b1011, new Bits().nextNumberSuccessor(0b111));
        assertEquals(0b1101, new Bits().nextNumberSuccessor(0b1011));
        assertEquals(0b1110, new Bits().nextNumberSuccessor(0b1101));
    }

    @Test
    void conversion() {
        assertEquals(2, new Bits().conversion(0b11101, 0b01111));
        assertEquals(3, new Bits().conversion(0b11101, 0b1));
        assertEquals(4, new Bits().conversion(0b11111, 0b1));
        assertEquals(5, new Bits().conversion(0b11111, 0b0));
    }

    @Test
    void pairwiseSwap() {
        assertEquals(0b00, new Bits().pairwiseSwap(0b00));
        assertEquals(0b10, new Bits().pairwiseSwap(0b01));
        assertEquals(0b01, new Bits().pairwiseSwap(0b10));
        assertEquals(0b0101, new Bits().pairwiseSwap(0b1010));
        assertEquals(0b1010, new Bits().pairwiseSwap(0b0101));
    }
}