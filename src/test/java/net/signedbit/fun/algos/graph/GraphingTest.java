package net.signedbit.fun.algos.graph;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphingTest {
    @Test
    void cycleShouldBeDetected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(4, 2);

        final boolean actual = new Graphing().hasCycle(graph);

        assertTrue(actual);
    }

    @Test
    void cycleShouldBeDetectedInDisconnected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(5, 6);
        graph.putEdge(6, 7);
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(4, 2);

        final boolean actual = new Graphing().hasCycle(graph);

        assertTrue(actual);
    }

    @Test
    void cycleShouldNotBeDetected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(2, 4);

        final boolean actual = new Graphing().hasCycle(graph);

        assertFalse(actual);
    }

    @Test
    void cycleShouldNotBeDetectedInDisconnected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(5, 6);
        graph.putEdge(6, 7);
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(2, 4);

        final boolean actual = new Graphing().hasCycle(graph);

        assertFalse(actual);
    }

    @Test
    void cycleShouldBeDetectedRecursive() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(4, 2);

        final boolean actual = new Graphing().hasCycleRecursive(graph);

        assertTrue(actual);
    }

    @Test
    void cycleShouldBeDetectedInDisconnectedRecursive() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(5, 6);
        graph.putEdge(6, 7);
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(4, 2);

        final boolean actual = new Graphing().hasCycleRecursive(graph);

        assertTrue(actual);
    }

    @Test
    void cycleShouldNotBeDetectedRecursive() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);

        final boolean actual = new Graphing().hasCycleRecursive(graph);

        assertFalse(actual);
    }

    @Test
    void cycleShouldNotBeDetectedInDisconnectedRecursive() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(5, 6);
        graph.putEdge(6, 7);
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);

        final boolean actual = new Graphing().hasCycleRecursive(graph);

        assertFalse(actual);
    }

    @Test
    void pathShouldBeDetected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 2);
        graph.putEdge(2, 3);
        graph.putEdge(3, 4);
        graph.putEdge(2, 4);
        graph.putEdge(4, 5);

        final List<Integer> actual = new Graphing().pathBetween(graph, 1, 5).get();
        final List<Integer> expected = ImmutableList.of(1, 2, 4, 5);

        assertIterableEquals(expected, actual);
    }

    @Test
    void pathShouldNotBeDetected() {
        final MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.putEdge(1, 3);
        graph.putEdge(2, 3);

        final boolean actual = new Graphing().pathBetween(graph, 1, 2).isPresent();

        assertFalse(actual);
    }

    @Test
    void bfsIterativeCorrectOrder() {
        final MutableGraph<Character> graph = GraphBuilder.directed().build();
        graph.putEdge('a', 'b');
        graph.putEdge('a', 'c');
        graph.putEdge('b', 'd');
        graph.putEdge('b', 'e');
        graph.putEdge('e', 'h');
        graph.putEdge('c', 'f');
        graph.putEdge('c', 'g');

        final ImmutableList<Character> expected = ImmutableList.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
        final ImmutableList<Character> actual = new Graphing().bfsIterative(graph, 'a');

        assertIterableEquals(expected, actual);
    }

    @Test
    void dfsRecursiveCorrectOrder() {
        final MutableGraph<Character> graph = GraphBuilder.directed().build();
        graph.putEdge('a', 'b');
        graph.putEdge('a', 'c');
        graph.putEdge('b', 'd');
        graph.putEdge('c', 'd');

        final ImmutableList<Character> expected = ImmutableList.of('a', 'b', 'd', 'c');
        final ImmutableList<Character> actual = new Graphing().dfsRecursive(graph, 'a', Lists.newArrayList());

        assertIterableEquals(expected, actual);
    }

    @Test
    void dfsIterativeCorrectOrder() {
        final MutableGraph<Character> graph = GraphBuilder.directed().build();
        graph.putEdge('a', 'b');
        graph.putEdge('a', 'c');
        graph.putEdge('b', 'd');
        graph.putEdge('c', 'd');

        final ImmutableList<Character> expected = ImmutableList.of('a', 'c', 'd', 'b');
        final ImmutableList<Character> actual = new Graphing().dfsIterative(graph, 'a');

        assertEquals(expected, actual);
    }

    @Test
    void topologicalSort() {
        final MutableGraph<Character> graph = GraphBuilder.directed().nodeOrder(ElementOrder.insertion()).build();
        graph.putEdge('a', 'b');
        graph.putEdge('a', 'c');
        graph.putEdge('b', 'd');
        graph.putEdge('c', 'd');

        final ImmutableList<Character> expected = ImmutableList.of('a', 'c', 'b', 'd');
        final ImmutableList<Character> actual = new Graphing().topologicalSort(graph);

        assertEquals(expected, actual);
    }
}