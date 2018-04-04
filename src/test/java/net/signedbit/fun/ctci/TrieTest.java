package net.signedbit.fun.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    @Test
    void getParent() {
        assertNull(new Trie<>('A').getParent());

        assertEquals(Character.valueOf('A'), new Trie<>('A', new Trie<>('B')).getChild('B').getParent().getDatum());
        assertEquals(Character.valueOf('A'), new Trie<>('A', new Trie<>('B'), new Trie<>('C')).getChild('C').getParent().getDatum());
    }

    @Test
    void setParent() {
        final Trie<String> trie = new Trie<>("A");
        final Trie<String> trie2 = new Trie<>("B");

        trie.setParent(trie2);
        assertEquals("B", trie.getParent().getDatum());
        assertEquals("B", trie2.getChild("A").getParent().getDatum());
    }

    @Test
    void getDatum() {
        assertNull(new Trie<>(null).getDatum());
        assertEquals(Character.valueOf('A'), new Trie<>('A').getDatum());
        assertEquals(Character.valueOf('B'), new Trie<>('B').getDatum());
    }

    @Test
    void getData() {
        assertArrayEquals(new Object[]{null}, new Trie<>(null).getData());
        assertArrayEquals(new Character[]{'A'}, new Trie<>('A').getData());

        final Trie<String> trie = new Trie<>("A");
        trie.addChildren(new String[]{"C", "T"});
        trie.addChildren(new String[]{"B", "S", "O", "L", "U", "T", "E"});
        trie.addChildren(new String[]{"B", "D", "U", "C", "T"});
        assertArrayEquals(new String[]{"A", "C", "T"}, trie.getChild("C").getChild("T").getData());
    }

    @Test
    void hasPrefix() {
        final Trie<String> trie = new Trie<>("A");
        trie.addChildren(new String[]{"C", "T"});
        trie.addChildren(new String[]{"B", "S", "O", "L", "U", "T", "E"});
        trie.addChildren(new String[]{"B", "D", "U", "C", "T"});

        assertFalse(trie.hasPrefix(new String[]{"D"}));
        assertFalse(trie.hasPrefix(new String[]{"C", "T", "S"}));
        assertFalse(trie.hasPrefix(new String[]{"B", "D", "O"}));
        assertFalse(trie.hasPrefix(new String[]{"B", "S", "U"}));

        assertTrue(trie.hasPrefix(new String[]{"C", "T"}));
        assertTrue(trie.hasPrefix(new String[]{"B"}));
        assertTrue(trie.hasPrefix(new String[]{"B", "S", "O"}));
        assertTrue(trie.hasPrefix(new String[]{"B", "D", "U"}));
    }

    @Test
    void addAllChildren() {
        final Trie<String> trie = new Trie<>("A");
        trie.addAllChildren(new String[][]{
                {"C", "T"},
                {"B", "S", "O", "L", "U", "T", "E"},
                {"B", "D", "U", "C", "T"}
        });

        assertFalse(trie.hasPrefix(new String[]{"D"}));
        assertFalse(trie.hasPrefix(new String[]{"B", "D", "O"}));
        assertFalse(trie.hasPrefix(new String[]{"B", "S", "U"}));

        assertTrue(trie.hasPrefix(new String[]{"C", "T"}));
        assertTrue(trie.hasPrefix(new String[]{"B"}));
        assertTrue(trie.hasPrefix(new String[]{"B", "S", "O"}));
        assertTrue(trie.hasPrefix(new String[]{"B", "D", "U"}));
    }

    @Test
    void addChild() {
    }

    @Test
    void addChild1() {
    }

    @Test
    void getChildren() {
    }

    @Test
    void removeChild() {
    }

    @Test
    void isRoot() {
    }

    @Test
    void isLeaf() {
    }
}