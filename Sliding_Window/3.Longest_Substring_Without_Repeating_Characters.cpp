#include<bits/stdc++.h>
using namespace std;

class Solution1 
{
    public:
    int lengthOfLongestSubstring(string s) 
    {
            unordered_set<int>ust;
            int left=0,maxi=0;
            for(int right=0; right<s.size(); right++)
            {
                while(ust.find(s[right]) != ust.end()) //element present
                {
                    ust.erase(s[left]);
                    left++;
                }
                ust.insert(s[right]);
                maxi = max(maxi,right-left+1);
            }
            return maxi;    
    }
};


class Solution2 
{
    public:
    int lengthOfLongestSubstring(string s) 
    {
        int size = s.size();
        unordered_map<char,int>ump;
        int left=0,right=0,length=0,maxi_length=0;

        while(right<size)
        {
            if(ump.find(s[right]) != ump.end() && ump[s[right]]>=left)
                left = ump[s[right]]+1;
            ump[s[right]]=right;

            length = right-left+1;
            maxi_length = max(length,maxi_length);
            right++;
        }    
        return maxi_length;
    }
    };