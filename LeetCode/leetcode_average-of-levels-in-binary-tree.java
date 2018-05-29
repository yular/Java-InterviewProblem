/*
*
* Tag: BFS
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
    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        final Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add( root );
        while(!curLevel.isEmpty()){
            final Queue<TreeNode> nextLevel = new LinkedList<>();
            long sum = 0;
            int numOfNodes = curLevel.size();
            while(!curLevel.isEmpty()){
                final TreeNode node = curLevel.remove();
                sum += node.val;
                if(node.left != null ){
                    nextLevel.add(node.left);
                }
                if(node.right != null ){
                    nextLevel.add(node.right);
                }
            }
            curLevel.addAll(nextLevel);
            final double averageValue = (double)sum/numOfNodes;
            ans.add(averageValue);
        }
        
        return ans;
    }
}
