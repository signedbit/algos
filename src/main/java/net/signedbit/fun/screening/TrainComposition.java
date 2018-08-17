package net.signedbit.fun.screening;

import java.util.LinkedList;

/**
 * I forget the exact problem statement but it was about building a train.
 */
public class TrainComposition {
    private final LinkedList<Integer> trains = new LinkedList<>();

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public void attachWagonFromLeft(int wagonId) {
        trains.addFirst(wagonId);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public void attachWagonFromRight(int wagonId) {
        trains.addLast(wagonId);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int detachWagonFromLeft() {
        return trains.removeFirst();
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int detachWagonFromRight() {
        return trains.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
