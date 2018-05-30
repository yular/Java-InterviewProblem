/*
*
* Tag: DP
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }
        
        int[] dp = new int[3];
        for(int i = 2; i <= cost.length; ++ i){
            dp[2] = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
            dp[0] = dp[1]; 
            dp[1] = dp[2];
        }
        
        return Math.min(dp[1], dp[2]);
    }
}
