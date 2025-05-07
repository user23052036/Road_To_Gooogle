/*
    one pass solution*****
    case 1: if arr[i]>sec_max && arr[i]<max then jyst update sec_max
    case 2: if arr[i]>max set the sec_max=max and max=arr[i]
*/

#include<bits/stdc++.h>
using namespace std;

class Solution 
{
    public:
      int getSecondLargest(vector<int> &arr) 
      {
          // code here
          int max = arr[0];
          int sec_max = -1;
          int size = arr.size();
          for(int i=1; i<size; i++)
          {
              if(arr[i]>sec_max && arr[i]<max)
                  sec_max = arr[i];
              else if(arr[i]>max)
              {
                  sec_max = max;
                  max = arr[i];
              }
          }
          return sec_max;
      }
  };