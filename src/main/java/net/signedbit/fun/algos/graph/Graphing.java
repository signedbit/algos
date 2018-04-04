package net.signedbit.fun.algos.graph;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.graph.Graph;

import java.util.*;

public class Graphing {
    public <T> boolean hasCycle(final Graph<T> graph) {
        for (final T target : graph.nodes()) {
            for (final T succ : graph.successors(target)) {
                final HashSet<T> visited = new HashSet<>();
                if (hasCycle(graph, visited, target, succ)) {
                    return true;
                }
            }
        }
        return false;
    }

    private <T> boolean hasCycle(final Graph<T> g, final Set<T> visited, final T target, final T node) {
        if (target == node) {
            return true;
        }
        visited.add(node);
        for (final T succ : g.successors(node)) {
            if (visited.contains(succ)) {
                continue;
            }
            if (hasCycle(g, visited, target, succ)) {
                return true;
            }
        }
        return false;
    }

    public <T> boolean hasCycleRecursive(final Graph<T> graph) {
        final Set<T> visited = Sets.newHashSet();
        final Set<T> pending = Sets.newHashSet();

        for (final T node : graph.nodes()) {
            if (hasCycleRecursive(graph, node, visited, pending)) {
                return true;
            }
        }

        return false;
    }

    private <T> boolean hasCycleRecursive(final Graph<T> g, final T node, final Set<T> visited, final Set<T> pending) {
        if (visited.contains(node)) {
            return false;
        }
        if (pending.contains(node)) {
            return true;
        }

        pending.add(node);

        for (final T succ : g.successors(node)) {
            if (hasCycleRecursive(g, succ, visited, pending)) {
                return true;
            }
        }

        pending.remove(node);
        visited.add(node);

        return false;
    }

    public <T> boolean pathBetweenExists(final Graph<T> graph, final T source, final T target) {
        return pathBetween(graph, source, target).isPresent();
    }

    public <T> Optional<List<T>> pathBetween(final Graph<T> graph, final T source, final T target) {
        final Set<T> visited = Sets.newHashSet();

        return Optional.ofNullable(pathBetweenVisit(graph, new Stack<>(), visited, source, target));
    }

    private <T> List<T> pathBetweenVisit(final Graph<T> graph, final Stack<T> path, final Set<T> visited, final T node, final T target) {
        if (visited.contains(node)) {
            return null;
        }
        path.push(node);

        if (node == target) {
            return path;
        }

        for (final T succ : graph.successors(node)) {
            final List<T> newPath = pathBetweenVisit(graph, path, visited, succ, target);
            if (newPath != null) {
                return newPath;
            }
        }

        path.pop();
        return null;
    }

    public <T> ImmutableList<T> dfsRecursive(final Graph<T> g, final T root, final List<T> visited) {
        if (visited.contains(root)) {
            return null;
        }

        visited.add(root);

        for (final T succ : g.successors(root)) {
            dfsRecursive(g, succ, visited);
        }

        return ImmutableList.copyOf(visited);
    }

    public <T> ImmutableList<T> dfsIterative(final Graph<T> g, final T root) {
        final List<T> visited = Lists.newArrayList();
        final Stack<T> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            final T node = stack.pop();
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            for (final T succ : g.successors(node)) {
                stack.push(succ);
            }

        }
        return ImmutableList.copyOf(visited);
    }

    public <T> ImmutableList<T> bfsIterative(final Graph<T> g, final T root) {
        final List<T> visitied = Lists.newArrayList();
        final Queue<T> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final T node = queue.poll();
            if (visitied.contains(node)) {
                continue;
            }

            visitied.add(node);

            for (final T succ : g.successors(node)) {
                queue.offer(succ);
            }
        }

        return ImmutableList.copyOf(visitied);
    }

    public <T> Optional<List<T>> find_path(final Graph<T> g, final T source, final T target) {
        final Set<T> visited = new HashSet<>();
        final Stack<T> path = new Stack<>();

        return Optional.ofNullable(find_path(g, path, visited, source, target));
    }

    private <T> List<T> find_path(final Graph<T> g, final Stack<T> path, final Set<T> visited, final T source, final T target) {
        if (visited.contains(source)) {
            return null;
        }

        System.out.println(source);
        if (source == target) {
            return path;
        }
        path.push(source);

        visited.add(source);

        for (final T succ : g.successors(source)) {
            final List<T> newPath = find_path(g, path, visited, succ, target);
            if (newPath != null) {
                return newPath;
            }
        }
        path.pop();
        return null;
    }

    public <T> ImmutableList<T> topologicalSort(final Graph<T> g) {
        final Deque<T> sorted = Queues.newArrayDeque();
        final Set<T> unvisited = Sets.newHashSet(g.nodes());
        final Set<T> temporary = Sets.newHashSet();
        final Set<T> permanently = Sets.newHashSet();
        while (!unvisited.isEmpty()) {
            final T node = unvisited.stream().findFirst().get();
            topologicalSort(g, node, sorted, temporary, permanently);

            unvisited.removeAll(temporary);
            unvisited.removeAll(permanently);
        }
        return ImmutableList.copyOf(sorted);
    }

    private <T> void topologicalSort(final Graph<T> g,
                                     final T node,
                                     final Deque<T> sorted,
                                     final Set<T> temporary,
                                     final Set<T> permanently) {
        if (permanently.contains(node)) {
            return;
        }
        if (temporary.contains(node)) {
            throw new RuntimeException("not a DAG");
        }

        temporary.add(node);

        for (final T succ : g.successors(node)) {
            topologicalSort(g, succ, sorted, temporary, permanently);
        }

        permanently.add(node);
        sorted.addFirst(node);
    }
}
