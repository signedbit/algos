package net.signedbit.fun.algos;

import net.signedbit.fun.ctci.BinarySearchTree;
import net.signedbit.fun.ctci.BinaryTree;
import net.signedbit.fun.ctci.MyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Trees {
    public <T extends Comparable> boolean isCompleteTree(final BinarySearchTree<T> tree) {
        if (tree == null) {
            return true;
        }
        return isCompleteTree(tree.getRoot());
    }

    public <T extends Comparable> boolean isCompleteTree(final BinaryTree<T> tree) {
        if (tree == null) {
            return false;
        }
        if (tree.isLeaf()) {
            return true;
        }

        final BinaryTree<T> left = tree.getLeft();
        final BinaryTree<T> right = tree.getRight();

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return left.isLeaf();
        }
        if (left != null && left.isLeaf() && !right.isLeaf()) {
            return false;
        }
        return isCompleteTree(left) && isCompleteTree(right);
    }

    public <T extends Comparable> boolean isFullTree(final BinarySearchTree<T> tree) {
        if (tree == null) {
            return false;
        }
        return isFullTree(tree.getRoot());
    }

    public <T extends Comparable> boolean isFullTree(final BinaryTree<T> root) {
        if (root == null) {
            return false;
        }
        if (root.isLeaf()) {
            return true;
        }
        return isFullTree(root.getLeft()) && isFullTree(root.getRight());
    }

    public <T extends Comparable> boolean isPerfectTree(final BinarySearchTree<T> tree) {
        if (tree == null) {
            return false;
        }
        return isPerfectTree(tree.getRoot());
    }

    public <T extends Comparable> boolean isPerfectTree(final BinaryTree<T> root) {
        if (root == null) {
            return false;
        }

        if (root.isLeaf()) {
            return root.isRoot();
        }

        final BinaryTree<T> left = root.getLeft();
        final BinaryTree<T> right = root.getRight();

        if (left == null || right == null) {
            return false;
        }

        if (left.isLeaf() && right.isLeaf()) {
            return true;
        }
        return isPerfectTree(left) && isPerfectTree(right);
    }

    public <T extends Comparable> List<BinaryTree<T>> preorder(final BinaryTree<T> tree) {
        final List<BinaryTree<T>> ordering = new ArrayList<>();
        preorder(tree, ordering);
        return ordering;
    }

    private <T extends Comparable> void preorder(final BinaryTree<T> tree, final List<BinaryTree<T>> list) {
        if (tree == null) {
            return;
        }

        list.add(tree);
        preorder(tree.getLeft(), list);
        preorder(tree.getRight(), list);
    }

    public <T extends Comparable> List<BinaryTree<T>> inorder(final BinaryTree<T> tree) {
        final List<BinaryTree<T>> ordering = new ArrayList<>();
        inorder(tree, ordering);
        return ordering;
    }

    private <T extends Comparable> void inorder(final BinaryTree<T> tree, final List<BinaryTree<T>> list) {
        if (tree == null) {
            return;
        }

        inorder(tree.getLeft(), list);
        list.add(tree);
        inorder(tree.getRight(), list);
    }

    public <T extends Comparable> List<BinaryTree<T>> postorder(final BinaryTree<T> tree) {
        final List<BinaryTree<T>> ordering = new ArrayList<>();
        postorder(tree, ordering);
        return ordering;
    }

    private <T extends Comparable> void postorder(final BinaryTree<T> tree, final List<BinaryTree<T>> list) {
        if (tree == null) {
            return;
        }

        postorder(tree.getLeft(), list);
        postorder(tree.getRight(), list);
        list.add(tree);
    }

    public <T extends Comparable> BinaryTree<T> buildMinimalTree(final List<T> values) {
        return buildMinimalTree(values, 0, values.size() - 1);
    }

    private <T extends Comparable> BinaryTree<T> buildMinimalTree(final List<T> values, final int start, final int end) {
        if (end < start) {
            return null;
        }
        final int center = (start + end) / 2;
        final BinaryTree<T> root = new BinaryTree<>(values.get(center));
        root.setLeft(buildMinimalTree(values, start, center - 1));
        root.setRight(buildMinimalTree(values, center + 1, end));
        return root;
    }

    public <T extends Comparable> List<MyLinkedList<T>> listOfDepths(final BinaryTree<T> root) {
        final Map<Integer, MyLinkedList<T>> levels = new TreeMap<>();
        listDepth(root, levels, 0);
        return new ArrayList<>(levels.values());
    }

    private <T extends Comparable> void listDepth(final BinaryTree<T> root, final Map<Integer, MyLinkedList<T>> levels, final int depth) {
        if (root == null) {
            return;
        }

        MyLinkedList<T> level = levels.get(depth);
        if (level == null) {
            level = new MyLinkedList<>();
            levels.put(depth, level);
        }

        level.append(root.getValue());

        listDepth(root.getLeft(), levels, depth + 1);
        listDepth(root.getRight(), levels, depth + 1);
    }

    public <T extends Comparable> boolean isBalanced(final BinaryTree<T> tree) {
        if (tree == null) {
            return false;
        }
        if (tree.isLeaf()) {
            return true;
        }
        if (tree.getLeft() == null) {
            return tree.getRight().isLeaf();
        }
        if (tree.getRight() == null) {
            return tree.getLeft().isLeaf();
        }

        final int leftHeight = tree.getLeft().getHeight();
        final int rightHeight = tree.getRight().getHeight();
        final int delta = Math.abs(leftHeight - rightHeight);
        return delta <= 1 && isBalanced(tree.getLeft()) && isBalanced(tree.getRight());
    }

    public <T extends Comparable> BinaryTree<T> successor(final BinaryTree<T> tree) {
        return successor(tree, null);
    }

    private <T extends Comparable> BinaryTree<T> successor(final BinaryTree<T> tree, final BinaryTree<T> prev) {
        if (tree.getRight() != null && tree.getRight() != prev) {
            BinaryTree<T> node = tree.getRight();
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        }
        final BinaryTree<T> parent = tree.getParent();
        if (parent.getLeft() == tree) {
            return parent;
        } else if (parent.getRight() == tree) {
            if (tree.getRight() == null) {
                return successor(parent, tree);
            }
            return tree.getRight();
        }
        throw new RuntimeException();
    }

    public <T extends Comparable> BinaryTree<T> firstCommonAncestor(final BinaryTree<T> node1, final BinaryTree<T> node2) {
        final int depth1 = depth(node1);
        final int depth2 = depth(node2);

        BinaryTree<T> node = depth1 > depth2 ? node1 : node2;
        int delta = depth1 > depth2 ? depth1 - depth2 : depth2 - depth1;
        while (delta-- > 0) {
            node = node.getParent();
        }

        if (node == node1) {
            return node1;
        } else if (node == node2) {
            return node2;
        }
        return null;
    }

    private <T extends Comparable> int depth(BinaryTree<T> node) {
        int depth = 0;
        while (node.getParent() != null) {
            node = node.getParent();
            depth++;
        }
        return depth;
    }
}
