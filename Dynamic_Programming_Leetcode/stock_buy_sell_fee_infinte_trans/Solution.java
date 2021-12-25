// problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// solution: https://www.youtube.com/watch?v=pTQB9wbIpfU
// pepcoding
package stock_buy_sell_fee_infinte_trans;
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp=-prices[0];
        int ossp=0;
        for(int i=1;i<prices.length;i++){
            int nbsp=0;
            int nssp=0;
            
            nbsp=Math.max(obsp,ossp-prices[i]);
            nssp=Math.max(ossp,prices[i]+obsp-fee);
            
            obsp=nbsp;
            ossp=nssp;
        }
        return ossp;
    }
}