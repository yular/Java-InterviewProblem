/*
*
* Tag: DFS
* Time: O(n)
* Space: O(n)
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    private double minDifference = 0;
    private int ans;
    
    public Solution(){
        ans = 0;
        minDifference = 0;
    }
    
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        minDifference = Math.abs(target - root.val);
        ans = root.val;
        dfs(root, target);
        return ans;
    }
    
    private void dfs(TreeNode root, double target){
        if(root.left != null){
            dfs(root.left, target);
        }
        
        double currentDifference = Math.abs(target - root.val);
        if(minDifference < currentDifference){
            return ;
        }
        minDifference = currentDifference;
        ans = root.val;
        
        if(root.right != null){
            dfs(root.right, target);
        }
    }
}
