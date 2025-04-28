#include<bits/stdc++.h>
using namespace std;


class Solution 
{
    public:
        vector<string> findRepeatedDnaSequences(string s) 
        {
            int size = s.length();
            vector<string>res;
            if(size<=10) return res;
    
            unordered_set<string>st;
            unordered_set<string>repeated;
            int left=0,right=0;
            string str;
    
            for(left=0; left<=size-10; left++)
            {
                str = s.substr(left,10);
                if(st.find(str) != st.end())
                    repeated.insert(str);
                else st.insert(str);
            }
            for(auto it:repeated)
                res.push_back(it);
    
            return res;
        }
    };