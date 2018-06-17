/*
*
* Tag: Hash
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if(S.length() == 0){
            return ans;
        }
        
        Map<Character, Integer> rightBoundOfChar = new HashMap<>();
        for(int i = 0; i < S.length(); ++ i){
            rightBoundOfChar.put(S.charAt(i), i);
        }
        
        int curRightBoundOfPartition = 0, anchor = 0;
        for(int i = 0; i < S.length(); ++ i){
            char key = S.charAt(i);
            curRightBoundOfPartition = Math.max(curRightBoundOfPartition, rightBoundOfChar.get(key));
            if(i == curRightBoundOfPartition) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        
        return ans;
    }
}
