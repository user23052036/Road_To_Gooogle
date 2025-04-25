#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) 
    {
        unordered_map<int,vector<int>>ump;
        int size=nums.size();

        for(int i=0; i<size; i++)   
        {
            if(ump.find(nums[i]) != ump.end())
            {
                if(i-ump[nums[i]][0] <= k || i-ump[nums[i]].back() <= k)
                    return true;
            }
            ump[nums[i]].push_back(i);
        }
        return false;
    }
};