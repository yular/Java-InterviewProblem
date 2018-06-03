/*
*
* Tag: Data Structure (Hash)
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[A.length];
        if(A.length == 0){
            return ans;
        }
        
        Map<Integer,Integer> indexOfElementsInArrayB = new HashMap<>();
        for(int i = 0; i < B.length; ++ i){
            indexOfElementsInArrayB.put(B[i], i);
        }
        
        for(int i = 0; i < A.length; ++ i) {
            ans[i] = indexOfElementsInArrayB.get(A[i]);
        }
        
        return ans;
    }
}
