/*
*
* Tag: Hash
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        if(J.isEmpty() || S.isEmpty()){
            return ans;
        }
        
        final Set<Character> jewels = new HashSet<>();
        for(char val : J.toCharArray()){
            jewels.add(val);
        }
        
        for(char val : S.toCharArray()){
            if(jewels.contains(val)){
                ++ ans;
            }
        }
        
        return ans;
    }
}
