/*
*
* Tag: Data Structure
* Time: O(n)
* Space: O(n)
*/
public class Solution {
    /**
     * @param nums: the arrays
     * @param k: the distance of the same number
     * @return: the ans of this question
     */
    public String sameNumber(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return "NO";
            
        Map<Integer, Integer> numToLastIndexInArray = new HashMap<>();
        for(int i = 0; i < nums.length; ++ i) {
            int num = nums[i];
            if(numToLastIndexInArray.containsKey(num)){
                int dist = i - numToLastIndexInArray.get(num);
                if(dist < k)
                    return "YES";
            }
            numToLastIndexInArray.put(num, i);
        }
        
        return "NO";
    }
}
