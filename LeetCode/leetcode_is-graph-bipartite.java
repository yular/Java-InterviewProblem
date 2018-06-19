/*
*
* Tag: DFS
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length < 2) {
            return true;
        }
        
        int[] colorOfNodes = new int[graph.length];
        initColorOfNodes(colorOfNodes);
        
        boolean ans = true;
        for(int i = 0; i < graph.length; ++ i){
            if(colorOfNodes[i] == -1) {
                colorOfNodes[i] = 0;
                ans &= canSetColorOfNodesReachedByNodeAsBipartite( i, colorOfNodes, graph );
            }
            
            if(!ans) {
                break;
            }
        }
        
        return ans;
    }
    
    private void initColorOfNodes(int[] colorOfNodes){
        for(int i = 0; i < colorOfNodes.length; ++ i){
            colorOfNodes[i] = -1;
        }
    }
    
    private boolean canSetColorOfNodesReachedByNodeAsBipartite( int startNode, int[] colorOfNodes, int[][] graph ) {
        boolean ans = true;
        
        for(int i = 0; i < graph[startNode].length; ++ i){
            int nextNode = graph[startNode][i];
            if(colorOfNodes[startNode] == colorOfNodes[nextNode]) {
                return false;
            }
            
            if(colorOfNodes[nextNode] == -1) {
                colorOfNodes[nextNode] = (colorOfNodes[startNode] + 1)%2;
                ans &= canSetColorOfNodesReachedByNodeAsBipartite( nextNode, colorOfNodes, graph );
            }
            
            if(!ans) {
                break;
            }
        }
        
        return ans;
    }
}
