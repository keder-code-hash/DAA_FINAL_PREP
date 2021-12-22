// stmt : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/
// sol : https://www.youtube.com/watch?v=GY0O57llkKQ 
// (pepcoding)
package stock_cool_down;
class Solution {
    public int maxProfit(int[] prices) {
        int obsp=-prices[0];
        int ossp=0;
        int ocsp=0;
        for(int i=1;i<prices.length;i++){
            int nbsp=0;
            int nssp=0;
            int ncsp=0;
            
            nbsp=Math.max(obsp,ocsp-prices[i]);
            nssp=Math.max(prices[i]+obsp,ossp);
            ncsp=Math.max(ocsp,ossp);
            
            obsp=nbsp;
            ossp=nssp;
            ocsp=ncsp;
        }
        return ossp;
    }
}


//  1 2 3  0 2
// -1 1 2 -1 2