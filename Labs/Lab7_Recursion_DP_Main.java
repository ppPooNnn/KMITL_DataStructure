package Labs;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;

import solutions.pack7_Recursion.EqualSubsets_66050261;
import solutions.pack7_Recursion.GridPaths_66050261;
import solutions.pack7_Recursion.Subsets_66050261;

public class Lab7_Recursion_DP_Main {
    public static void main(String[] args) {
        // testEqualSubsets();
        // System.out.println("----");
        // testSubSets();
        testGridPaths();
    }
    static void testEqualSubsets() {
        int [] a = {1,5,11,5};
        int [] b = {1,5,3};
        // System.out.println(EqualSubsets.canPartition_Recur(a));
        // System.out.println(EqualSubsets.canPartition_Recur(b));
        // System.out.println(EqualSubsets.canPartition_Memoiz(a));
        // System.out.println(EqualSubsets.canPartition_Memoiz(b));
        System.out.println(EqualSubsets_66050261.canPartition_DP(a));
        System.out.println(EqualSubsets_66050261.canPartition_DP(b));     
    }
    static void testSubSets() { 
        System.out.println("--- Subsets ---");
        List<Integer> set = new ArrayList<>();
        set.add(1); set.add(2); set.add(3);
        System.out.println("using recursive method");
        Subsets_66050261.printAllSubsetsRecur(set);
        System.out.println("using dynamic programming method");
        Subsets_66050261.printAllSubsetsDP(set);
    }
    static void testGridPaths() {
        int [][] grid = { {0,0,0,0},
                          {0,1,0,0},  
                          {0,0,0,1},
                          {1,0,0,0}};
        System.out.println("--- grid paths ---");
        System.out.println("number of paths: " + GridPaths_66050261.numberOfPaths(grid));
    }
}
