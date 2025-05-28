package Array.SDE_Array;


// Dutch National flag algorithm
//leetcode-75
class Solution
{
    public void sortColors(int[] nums) 
    {
        int size = nums.length;
        int low=0,mid=0,high=size-1;

        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                swap(nums,mid,high);
                high--;
            }
        }    
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
