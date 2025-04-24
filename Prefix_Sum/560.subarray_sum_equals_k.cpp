#include<bits/stdc++.h>
using namespace std;

//TC-> O(N^3)
//SC->O(1)
class Solution1
{
    public:
    int brute_force(vector<int>&nums, int k)
    {
        int cnt=0;
        int size=nums.size();
        for(int i=0; i<size; i++)
        {
            for(int j=i; i<size; j++)
                if(sum(nums,i,j)==k)cnt++;
        }
        return cnt;
    }
    private:
    int sum(vector<int>nums,int i,int j)
    {
        int val_sum=0;
        for(;i<=j; i++)
            val_sum += nums[i];
        
        return val_sum;
    }
};


//TC-> O(N)
//SC->O(N) for the unordered map 
class Solution2
{
    public:
    int optimal(vector<int>&nums, int k)
    {
        unordered_map<int,int>ump;
        int size=nums.size();
        int sub_array=0;
        int cnt=0;

        for(int i=0; i<size; i++)
        {
            sub_array += nums[i];

            if(sub_array==k) cnt++; // or need to push (0,1) into the map so that ump.find(sub_array-k)==0 is present in the map if sub_array==k

            if(ump.find(sub_array-k) != ump.end())
                cnt += ump[sub_array-k];
            ump[sub_array]++;
        }
        return cnt;
    }
};