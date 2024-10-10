package solutions.pack12b_SSP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Task3_660261 {
    
    public int stateSpace(int[] beginState, int[] goalState){

        InterfaceSwapAdjacentPairs swapPairs = (State s) -> {
            int[] array = s.getArray().clone();
            for (int i = 0; i < array.length - 1; i += 2) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
            return array;
        };

        InterfaceSwapCorrespondingHalves swapHalves = (State s) -> {
            int[] array = s.getArray().clone();
            int n = array.length / 2;
            for (int i = 0; i < n; i++) {
                int temp = array[i];
                array[i] = array[n + i];
                array[n + i] = temp;
            }
            return array;
        };

        if (Arrays.equals(beginState, goalState)) return 0;

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        queue.add(new State(beginState));
        visited.add(new State(beginState));

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                State current = queue.poll();

                int[] newState1 = swapPairs.swapAdjacentPairs(current);
                State state1 = new State(newState1);
                if (Arrays.equals(newState1, goalState)) {
                    return level;
                }
                if (visited.add(state1)) {
                    queue.offer(state1);
                }

                int[] newState2 = swapHalves.swapCorrespondingHalves(current);
                State state2 = new State(newState2);
                if (Arrays.equals(newState2, goalState)) {
                    return level;
                }
                if (visited.add(state2)) {
                    queue.offer(state2);
                }
            }
        }

        return -1;
    }
}
