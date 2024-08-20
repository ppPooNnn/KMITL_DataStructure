package solutions.pack7_Recursion;

public class GridPaths_66050261 
{
    public static int numberOfPaths(int[][] grid)
    {
        int[][] res = new int[grid.length][grid[0].length];

        for(int i = 0; i < res.length; i++)
        {
            for(int j = 0; j < res[0].length; j++)
            {
                if(grid[i][j] == 1)
                    continue;
                
                if(i == 0 || j == 0)
                {
                    res[i][j] = 1;
                    continue;
                }

                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[res.length - 1][res[0].length - 1];
    }
}