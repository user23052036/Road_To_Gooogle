#include<bits/stdc++.h>
using namespace std;

class Solution1
{
    public:
        bool checkSubarraySum(vector<int>& nums, int k) 
        {
            int size=nums.size();
            unordered_map<int,int>ump;
            ump[0]=-1;  // for thr case of when subarray is completely divisible need to make sure is of the length >=2
            int prefix_sum=0;
            int remainder=0;

            for(int i=0; i<size; i++) 
            {
                prefix_sum += nums[i];
                remainder = prefix_sum%k;
                if(ump.find(remainder) != ump.end())
                {
                    if(i-ump[remainder] >= 2) return true;
                    else continue;
                }
                ump[remainder]=i;
            }
            return false;   
        }
};