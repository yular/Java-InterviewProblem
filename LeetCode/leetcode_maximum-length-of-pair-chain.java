/*
*
* Tag: Greedy
* Time: O(nlgn)
* Space: O(lgn)
*/
class Solution {
    public int findLongestChain(int[][] pairs) {
        int ans = 0;
        if(pairs.length == 0){
            return ans;
        }
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int n = pairs.length;
        int curChainRightBound = pairs[0][1];
        ans = 1;
        for(int i = 1; i < n; ++ i){
            if(pairs[i][0] > curChainRightBound) {
                curChainRightBound = pairs[i][1];
                ++ ans;
            }
        }
        
        return ans;
    }
}
