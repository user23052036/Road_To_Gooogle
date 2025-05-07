
/*
    method-1(recursion)
    TC-> O(N)
    SC-> O(N)

    method-2(one pass solution)
    first move to the part of element in the array with 0
    arr= 2 4 6 4 5 8 7 0 8 76 0 5 0
    arr= 0 8 76 0 5 0
    iterate throgh with two pointer z(zero) and nz(non-zero) and swap them
    TC-> O(N)
    SC-> O(1)

    method-3(inbuild function)
    reverse(arr.begin(),arr.end());
    TC-> O(N)
    SC-> O(1)
*/
#include<bits/stdc++.h>
using namespace std;

class Solution2 
{
    public:
        void moveZeroes(vector<int>& nums) 
        {
            int z=-1;
            for(int i=0; i<nums.size(); i++)
            {
                if(nums[i]==0)
                {
                    z=i;
                    break;
                }   
            }

            if(z==-1) return;
            for(int nz=z+1; nz<nums.size(); nz++)
            {
                if(nums[nz] != 0)
                {
                    swap(nums[z],nums[nz]);
                    z++;
                }
            } 
        }
};