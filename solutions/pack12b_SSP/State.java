package solutions.pack12b_SSP;

import java.util.Arrays;

public class State {
    int[] array;

    public State(int[] array) {
        this.array = array.clone();  // Ensure we make a copy of the array
    }

    // Override equals and hashCode for comparison in sets or queues
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Arrays.equals(array, state.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    // To access the array
    public int[] getArray() {
        return array;
    }
}
