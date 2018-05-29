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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        root.left = pruneTree( root.left );
        root.right = pruneTree( root.right );
        
        return (root.left == null && root.right == null && root.val == 0 )? null : root;
    }
}
