package Array.SDE_Array;

//leetcode-121 refer my video https://www.youtube.com/watch?v=0x9wdq8tgoo
class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int size = prices.length;
        int buy=0,sell=1,maxi=0;

        while(sell<size)
        {
            int profit = prices[sell]-prices[buy];
            if(profit>0)
                maxi = max(maxi,profit);
            else buy=sell;
            sell++;
        }
        return maxi;
    }
    private int max(int a, int b)
    {
        return (a>=b)? a:b;
    }
}