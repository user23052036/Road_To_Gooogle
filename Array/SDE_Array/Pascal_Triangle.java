package Array.SDE_Array;
import java.util.*;

// Solution 1: Find Element at Position (r, c) in Pascal's Triangle
class Solution1 
{
    // Time Complexity: O(c)
    // Space Complexity: O(1)
    public int nCr(int n, int r) 
    {
        int res = 1;
        for (int i = 0; i < r; i++) 
        {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Returns the element at (row, col) in Pascal's Triangle (1-based indexing)
    public int getPascalElement(int row, int col) {
        return nCr(row - 1, col - 1);
    }
}

// Solution 2: Generate nth Row of Pascal's Triangle
class Solution2 
{
    // Brute Force: Using nCr for each element
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public List<Integer> getRowBrute(int rowIndex) 
    {
        List<Integer> row = new ArrayList<>();
        for (int c = 0; c <= rowIndex; c++) 
        {
            row.add(nCr(rowIndex, c));
        }
        return row;
    }

    // Helper for nCr
    private int nCr(int n, int r) 
    {
        int res = 1;
        for (int i = 0; i < r; i++) 
        {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Optimal: In-place row construction
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public List<Integer> getRowOptimal(int rowIndex) 
    {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 1);
        for (int i = 2; i <= rowIndex; i++) 
        {
            for (int j = i - 1; j > 0; j--) 
                row[j] = row[j] + row[j - 1];
        }
        return Arrays.asList(row);
    }
}



// Solution 3: Generate Full Pascal's Triangle up to nth Row(MY SOLUTION in 33 min)
class Solution3 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) 
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) 
            {
                if (i-1 >= 0 && j-1 >= 0 && j != i) 
                {
                    int val = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(val);
                } else row.add(1);
            }
            result.add(row);
        }
        return result;
    }
}

