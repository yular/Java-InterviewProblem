/*
*
* Tag: DP
* Time: O(n^2)
* Space: O(n)
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int ans = 0;
        if(nums.length == 0){
            return ans;
        }
        
        int n = nums.length;
        int[][] dp = new int[n][2];
        int lengthOfLongestSubsequence = 0;
        for(int i = 0; i < n; ++ i){
            dp[i][0] = dp[i][1] = 1;
            for(int j = 0; j < i; ++ j) {
                if(nums[j] < nums[i]) {
                    if(dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if(dp[j][0] + 1 == dp[i][0]){
                        dp[i][1] += dp[j][1]; 
                    }
                }
            }
            
            lengthOfLongestSubsequence = Math.max(lengthOfLongestSubsequence, dp[i][0]);
        }
        
        for(int i = 0; i < n; ++ i){
            if(dp[i][0] == lengthOfLongestSubsequence){
                ans += dp[i][1];
            }
        }
        
        return ans;
    }
}
