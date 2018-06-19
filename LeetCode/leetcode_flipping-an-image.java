/*
*
* Tag: Implementation
* Time: O(n*m)
* Space: O(1)
*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = A;
        if(A.length == 0) {
            return ans;
        }
        
        reverseImage( ans );
        
        invertImage( ans );
        
        return ans;
    }
    
    private void reverseImage(int[][] A){
        for(int[] row : A){
            int numOfColumns = row.length;
            for(int i = 0; i < (numOfColumns + 1)/2; ++ i){
                int tmp = row[i];
                row[i] = row[numOfColumns - i - 1];
                row[numOfColumns - i - 1] = tmp;
            }
        }
    }
    
    private void invertImage(int[][] A){
        for(int i = 0; i < A.length; ++ i){
            for(int j = 0; j < A[i].length; ++ j){
                A[i][j] ^= 1;
            }
        }
    }
}
