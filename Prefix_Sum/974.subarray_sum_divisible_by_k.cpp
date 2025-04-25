#include<bits/stdc++.h>
using namespace std;

class Solution 
{
    public:
        int subarraysDivByK(vector<int>& nums, int k) 
        {
            int size = nums.size();
            int cnt=0;
            unordered_map<int,int>ump;
            ump[0]=1;
            int prefix_sum=0;
            int remainder=0;

            for(int i=0; i<size; i++)
            {
                prefix_sum += nums[i];
                remainder = prefix_sum%k;
                if(remainder<0) remainder+=k;     // to remove all the negative remainders so that we can cheak if they lie on the same group and put then under the same group in the map

                if(ump.find(remainder) != ump.end())
                    cnt += ump[remainder];
                ump[remainder]++;
            }
            return cnt;
        }
};