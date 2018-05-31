/*
*
* Tag: DFS
* Time: O(n^2)
* Space: O(n)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return nums.length == 0? null : buildMaximumBinaryTree(nums, 0, nums.length);
    }
    
    private TreeNode buildMaximumBinaryTree(int[] nums, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return null;
        }
        
        int indexOfMaxValue = getIndexOfMaxValue(nums, startIndex, endIndex);
        int maxValue = nums[indexOfMaxValue];
        
        TreeNode root = new TreeNode(maxValue);
        root.left = buildMaximumBinaryTree(nums, startIndex, indexOfMaxValue);
        root.right = buildMaximumBinaryTree(nums, indexOfMaxValue + 1, endIndex);
        
        return root;
    }
    
    private int getIndexOfMaxValue(int[] nums, int startIndex, int endIndex){
        int indexOfMaxValue = startIndex;
        int maxValue = nums[startIndex];
        for(int i = startIndex; i < endIndex; ++ i){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                indexOfMaxValue = i;
            }
        }
        
        return indexOfMaxValue;
    }
}
