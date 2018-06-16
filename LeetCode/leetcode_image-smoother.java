/*
*
* Tag: Implementation
* Time: O(n*m)
* Space: O(1)
*/
class Solution {
    private int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    
    public int[][] imageSmoother(int[][] M) {
        int numOfRows = M.length, numOfColumns = M[0].length;
        int[][] averageGrayScale = new int[numOfRows][numOfColumns];
        
        for(int i = 0; i < numOfRows; ++ i){
            for(int j = 0; j < numOfColumns; ++ j){
                averageGrayScale[i][j] = getAverageGrayScaleOf(i, j, M);
            }
        }
        
        return averageGrayScale;
    }
    
    private int getAverageGrayScaleOf(int r, int c, int[][] M){
        int sum = M[r][c], cnt = 1;
        int numOfRows = M.length, numOfColumns = M[0].length;
        
        for(int i = 0; i < 8; ++ i){
            int nextRow = r + dir[i][0], nextColumn = c + dir[i][1];
            if(nextRow >= 0 && nextRow < numOfRows && nextColumn >= 0 && nextColumn < numOfColumns){
                sum += M[nextRow][nextColumn];
                ++ cnt;
            }
        }
        
        return sum/cnt;
    }
}
