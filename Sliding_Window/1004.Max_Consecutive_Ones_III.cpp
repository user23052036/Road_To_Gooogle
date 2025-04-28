#include<bits/stdc++.h>
using namespace std;

class Solution 
{
    public:
        int longestOnes(vector<int>& nums, int k) 
        {
            int zeros=0,left=0,right=0;
            int temp_len=0,final_len=0;
            int size=nums.size();

            while(right<size)
            {
                if(nums[right] == 0) zeros++;
                if(zeros>k)
                {
                    if(nums[left] == 0) zeros--;
                    left++;
                }
                temp_len = right-left+1;
                final_len = max(final_len,temp_len);
                right++;
            }
            return final_len;
        }
};