package net.signedbit.fun.algos.tree;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.util.List;
import java.util.Queue;

public class TreeTraversal {
    public <T> ImmutableList<T> preorder(final TreeNode<T> root) {
        final List<T> nodes = Lists.newArrayList();
        preorder(root, nodes);
        return ImmutableList.copyOf(nodes);
    }

    private <T> void preorder(final TreeNode<T> root, final List<T> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.getData());
        preorder(root.getLeft(), nodes);
        preorder(root.getRight(), nodes);
    }

    public <T> ImmutableList<T> inorder(final TreeNode<T> root) {
        final List<T> nodes = Lists.newArrayList();
        inorder(root, nodes);
        return ImmutableList.copyOf(nodes);
    }

    private <T> void inorder(final TreeNode<T> root, final List<T> nodes) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft(), nodes);
        nodes.add(root.getData());
        inorder(root.getRight(), nodes);
    }

    public <T> ImmutableList<T> postorder(final TreeNode<T> root) {
        final List<T> nodes = Lists.newArrayList();
        postorder(root, nodes);
        return ImmutableList.copyOf(nodes);
    }

    private <T> void postorder(final TreeNode<T> root, final List<T> nodes) {
        if (root == null) {
            return;
        }

        postorder(root.getLeft(), nodes);
        postorder(root.getRight(), nodes);
        nodes.add(root.getData());
    }

    public <T> ImmutableList<T> levelorder(final TreeNode<T> root) {
        final List<T> nodes = Lists.newArrayList();
        final Queue<TreeNode<T>> queue = Queues.newArrayDeque();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode<T> node = queue.poll();
            nodes.add(node.getData());

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }

        return ImmutableList.copyOf(nodes);
    }
}
