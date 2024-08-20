package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_66050261 
{
    public static void printAllSubsetsRecur(List<Integer> set)
    {
        List<Integer> res = new ArrayList<>();
        printAllSubsetsRecur(set, 0, res);
        System.out.println();
    }

    private static void printAllSubsetsRecur(List<Integer> set, int index,List<Integer> res)
    {
        if(index == set.size())
        {
            System.out.print(res.toString() + ", ");
            return;
        }

        res.add(set.get(index));
        printAllSubsetsRecur(set, index + 1, res);

        res.remove(res.size() - 1);
        printAllSubsetsRecur(set, index + 1, res);
    }

    public static void printAllSubsetsDP(List<Integer> set)
    {
        List<List<Integer>> allSubsets = new ArrayList<>();

        allSubsets.add(new ArrayList<>());

        for (Integer num : set) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            allSubsets.addAll(newSubsets);
        }

        for(List<Integer> subset : allSubsets)
            System.out.print(subset.toString() + ", ");
    }
}