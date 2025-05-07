
/*
    method-1(recursion)
    TC-> O(N)
    SC-> O(N)

    method-2(one pass solution)
    arr[i] != arr[size-1-i] swap them till mid

    method-3(inbuild function)
    reverse(arr.begin(),arr.end());
    TC-> O(N)
    SC-> O(1)
*/

#include<bits/stdc++.h>
using namespace std;

class Solution1
{
    public:
    void reverseArray(vector<int> &arr)
    {
        recursive_rev(arr,0,arr.size()-1);
    }
    private:
    void recursive_rev(vector<int>&arr,int left,int right)
    {
        if(left>=right) return;

        if(arr[left] != arr[right])
            swap(arr[left],arr[right]);
        recursive_rev(arr,left+1,right-1);
    }
};

class Solution2 
{
    public:
      void reverseArray(vector<int> &arr) 
      {
          // code here
          int size = arr.size();
          int mid = size/2;
          for(int i=0; i<mid; i++)
          {
              if(arr[i] != arr[size-1-i])
                  swap(arr[i],arr[size-1-i]);
          }
      }
  };

  
// C++ Program to reverse an array using inbuilt methods
void reverseArray(vector<int> &arr) 
{
    reverse(arr.begin(), arr.end());
}