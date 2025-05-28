package Array.SDE_Array;

//leetcode- 287
// using tortoise and hair algo same algo used in finding starting point in the linked list
class Find_The_Duplicate_Number 
{
    public int findDuplicate(int[] nums) 
    {
       int slow=nums[0],fast=nums[0];

       while(true)
       {
        slow = nums[slow];
        fast = nums[nums[fast]];

        if(slow==fast) break;
       }
       slow=nums[0];
       while(slow != fast)
       {
        slow = nums[slow];
        fast = nums[fast];
       }
       return slow;
    }  
}
