package solutions.pack7_Recursion;

public class EqualSubsets_66050261 
{
    public static boolean canPartition_Recur(int[] arr)
    {
        int sum = 0;

        for(int n : arr)
            sum += n;

        if(sum % 2 != 0)
            return false;
        return canPartition_Recur(arr, arr.length, sum / 2);
    }

    public static boolean canPartition_Recur(int[] arr, int index, int sum)
    {
        if(sum == 0)
            return true;
        
        if(index == 0 && sum != 0)
            return false;

        if(arr[index - 1] > sum)
            return canPartition_Recur(arr, index - 1, sum);

        return canPartition_Recur(arr, index - 1, sum - arr[index - 1]) || canPartition_Recur(arr, index - 1, sum);
    }

    public static boolean canPartition_Memoiz(int[] arr)
    {
        int sum = 0;

        for(int n : arr)
            sum += n;

        if(sum % 2 != 0)
            return false;

        boolean[] mem = new boolean[arr.length + 1];
        return canPartition_Memoiz(arr, arr.length, sum / 2, mem);
    }

    public static boolean canPartition_Memoiz(int[] arr, int index, int sum, boolean[] mem)
    {
        if(sum == 0)
            return true;
        
        if(index == 0 && sum != 0)
            return false;

        if(mem[index])
            return mem[index];

        if(arr[index - 1] > sum)
            return canPartition_Memoiz(arr, index - 1, sum, mem);

        return canPartition_Memoiz(arr, index - 1, sum - arr[index - 1], mem) || canPartition_Memoiz(arr, index - 1, sum, mem);
    }

    public static boolean canPartition_DP(int[] arr)
    {
        int sum = 0;

        for(int n : arr)
            sum += n;

        if(sum % 2 != 0)
            return false;

        boolean[] result = new boolean[(sum / 2) + 1];
        result[0] = true;

        for(int num : arr)
        {
            for(int j = sum / 2; j >= num; j--)
            {
                result[j] = result[j] || result[j - num];
            }
        }

        return result[sum / 2];
    }
}
