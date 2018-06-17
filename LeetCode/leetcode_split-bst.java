/*
*
* Tag: DFS
* Time: O(n)
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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null)
            return new TreeNode[]{null, null};
        
        TreeNode[] ans = new TreeNode[]{null, null};
        if(root.val <= V) {
            ans = splitBST(root.right, V);
            root.right = ans[0];
            ans[0] = root;
        } else {
            ans = splitBST(root.left, V);
            root.left = ans[1];
            ans[1] = root;
        }
        
        return ans;
    }
}
