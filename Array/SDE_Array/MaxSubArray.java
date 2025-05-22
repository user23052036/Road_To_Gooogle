package Array.SDE_Array;

/*
 * In the brite for ce solution we can computer all the possible subarrays and then for each of the sum array
 * run a seperate loop to compute the subarray sum.
 * TC->O(N^3)
 * SC->O(1)
 */

class MaxSubArray1
{
    public int maxSubArray(int[] nums) 
    {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++) 
            {
                int currentSum = 0;
                for (int k = i; k <= j; k++) 
                    currentSum += nums[k];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}

/*
 * in the little optimal way we can decrease the time complexity to O(N^2) by geeting rid of the inner-inner 
 * for loop to compute. the sum instead we can apply the method of the prefix sum technique.
 */

 class MaxSubArray2 
 {
    public int maxSubArray(int[] nums) 
    {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) 
        {
            int currentSum = 0;
            for (int j = i; j < n; j++) 
            {
                currentSum += nums[j];  // Eliminates inner loop by prefix sum technique
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}

// kaidence algo tc->O(N) explaination in older copy

public class MaxSubArray 
{
    public int maxSubArray(int[] nums) 
    {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
        {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

