// brute force would be taking an bool array of the size of the nums as... then ans can be between [1 - nums.size()+1]
// for example nums=[7,5,6,4,3] nums.size() = 5 so ans can be between 1-6

/*
    method-1 (brute force) 
    1. sort the array
    2. set min=1 search through the array to find the missing smallest term
    TC-> O(NlogN)+O(N)
    SC-> 0(1)


    method-2 (optimal) solution set [1 - length(nums)+1]
    1. remove all the negative,zero, any number greater than length(nums) and keep all the req number in HashTable of size size+1
    2. set the hashTable with all innitial value -1
    3. Iterate through the nums and put all the req req number as the HashTable indx and set it to 1
    4. finally iterate through the HashTable and find the first indx with -1 return indx. else return size+1at the end of the for loop
    TC-> O(N)
    SC-> 0(sizeof(N))


    METHOD-3 (most optimal) this can be used at a lots of problems searching in O(1)
    1. first iterate through the nums and set all <0 -> 0
    2. iterate the second time and this time we want to search each element in the resulting set[1 - size+1] at O(1) time 
        so... we will do indx = element-1 and set element at this indxto negative kepping the magnitude same.. so that we know this element is present.
        #case-1: 
            if the element is 0 indx cant be set to -1 that will be wrong so dont care
        #case-2:
            if the indx is +ve set the elemnt in that indx with same magnitude but negative.
    3. In the final iteration we will run a loop over our solution set considering each as element and finding indx = element-1
        and if nums[indx] >= 0 return element else at the end of the loop return (size+1)
    *** we wrote in the 4th step nums[indx]==0 because consider the solution set element 1 so indx = 0 ****
    TC-> O(3N) ~ O(N)
    SC-> O(1)
    */

    //method-2
#include<bits/stdc++.h>
using namespace std;
class Solution1 
{
public:
    int firstMissingPositive(vector<int>& nums)
    {
        int size = nums.size();
        int HashTable[size+1];
        for(int i=0; i<size+1; i++)
            HashTable[i] = -1;
        for(auto it: nums)
        {
            if(it<=0 || it>size) continue;
            HashTable[it] = 1;
        }
        
        for(int i=1; i<=size; i++)
            if(HashTable[i] == -1) return i;
        return size+1;
    }
    };

    
//method-3
class Solution 
{
public:
    int firstMissingPositive(vector<int>& nums) 
    {
        int size = nums.size();
        for(int i=0; i<size; i++)
            if(nums[i]<0) nums[i]=0;
        
        for(int i=0; i<size; i++)
        {
            int element = abs(nums[i]);
            int indx = element-1; // we assumes to make it work in O(1)

            if(indx>=0 && indx<size)
            {
                if(nums[indx] > 0) nums[indx] = -nums[indx];
                else if(nums[indx] == 0) nums[indx] = -(size+1);
            }
        }

        for(int element=1; element<=size; element++)
        {
            int indx = element-1;
            if(nums[indx] >= 0) return element;
        }
        return size+1;
    }
};
