package net.signedbit.fun.algos.tree;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTraversalTest {
    private final TreeNode<Character> tree =
            new TreeNode<>('F',
                    new TreeNode<>('B',
                            new TreeNode<>('A'),
                            new TreeNode<>('D',
                                    new TreeNode<>('C'),
                                    new TreeNode<>('E')
                            )
                    ),
                    new TreeNode<>('G',
                            null,
                            new TreeNode<>('I',
                                    new TreeNode<>('H'),
                                    null)
                    )
            );

    @Test
    void preorder() {
        final ImmutableList<Character> expected = ImmutableList.of('F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H');
        final ImmutableList<Character> actual = new TreeTraversal().preorder(tree);

        assertEquals(expected, actual);
    }

    @Test
    void inorder() {
        final ImmutableList<Character> expected = ImmutableList.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I');
        final ImmutableList<Character> actual = new TreeTraversal().inorder(tree);

        assertEquals(expected, actual);
    }

    @Test
    void postorder() {
        final ImmutableList<Character> expected = ImmutableList.of('A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F');
        final ImmutableList<Character> actual = new TreeTraversal().postorder(tree);

        assertEquals(expected, actual);
    }

    @Test
    void levelorder() {
        final ImmutableList<Character> expected = ImmutableList.of('F', 'B', 'G', 'A', 'D', 'I', 'C', 'E', 'H');
        final ImmutableList<Character> actual = new TreeTraversal().levelorder(tree);

        assertEquals(expected, actual);
    }
}