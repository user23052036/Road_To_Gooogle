package Array.SDE_Array;

// Solution1: Brute Force Approach (Conceptual Only)
// Time Complexity: O(n! * n)
// Space Complexity: O(n! * n)
// Note: This is a conceptual brute force; in practice, do not implement this for large arrays.
class Solution1 
{
    /*
    // Conceptual steps:
    // 1. Generate all permutations of the array.
    // 2. Sort all permutations lexicographically.
    // 3. Find the current permutation, and return the next one.
    // If current is the last, return the first (sorted) permutation.
    // Not implemented due to impracticality.
    */
}

////////////////////////////////////////////////////////

// Solution2: Optimal In-Place Approach (as taught in the video)
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        int indx = -1;
        int size = nums.length;
        
        // Step 1: Find the first index 'indx' from the end where nums[indx] < nums[indx+1]
        for(int i = size - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                indx = i;
                break;
            }
        }
        
        // Edge case: If no such index exists, reverse the entire array
        if(indx == -1)
        {
            Reverse(nums, 0, size); // Reverse from [0, size) (exclusive end)
            return;
        }
        
        // Step 2: Find the smallest element > nums[indx] in the suffix (nums[indx+1...end])
        for(int i = size - 1; i > indx; i--)
        {
            if(nums[i] > nums[indx])
            {
                Swap(nums, i, indx); // Swap with the found element
                break;
            }
        }
        
        // Step 3: Reverse the suffix to get the smallest lex order
        Reverse(nums, indx + 1, size);
    }

    // Reverses elements in nums[start] to nums[end-1] (exclusive end)
    void Reverse(int[] nums, int start, int end) 
    {
        int left = start;
        int right = end - 1; // Convert exclusive end to inclusive index
        while (left < right) 
        {
            Swap(nums, left, right);
            left++;
            right--;
        }
    }

    // Swaps elements at indices i and j
    void Swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


