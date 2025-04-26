#include<bits/stdc++.h>
using namespace std;

class Solution 
{
    public:
        int maxScore(vector<int>& cardPoints, int k) 
        {
            int size = cardPoints.size(),result=0;
            if(size<k) return 0;
            if(size==k) return accumulate(cardPoints.begin(),cardPoints.end(),0);
            else
            {
                int left_sum=0,right_sum=0,cnt=0;
                for(int i=0; i<k; i++)
                    left_sum += cardPoints[i];

                result = left_sum;
                for(int i=k-1; i>=0; i--)
                {
                    left_sum -= cardPoints[i];
                    right_sum += cardPoints[size-1-cnt];
                    cnt++;
                    result = max(result,(left_sum+right_sum));
                }
            }
            return result;
        }
};