/*
*
* Tag: BFS
* Time: O(n^2)
* Space: O(n^2)
*/
public class Solution {
    private class Point {
        private int row;
        private int column;
        
        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
        public int getRow(){
            return row;
        }
        
        public int getColumn(){
            return column;
        }
    };
    
    private static final int[][] directions = new int[][]{
        {-1, 0}, {1, 0}, {0,-1}, {0, 1}
    };
    
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if( rooms.length == 0 ) {
            return ;
        }
        
        final List<Point> gates = findGatesOf(rooms);
        
        gates.stream().forEach( gate -> breadthFirstSearch( gate, rooms ) );
        
        return ;
    }
    
    private List<Point> findGatesOf(int[][] rooms) {
        final List<Point> gates = new ArrayList<>();
        final int numOfRows = rooms.length;
        final int numOfColumns = rooms[0].length;
        
        for(int row = 0; row < numOfRows; ++ row){
            for(int column = 0; column < numOfColumns; ++ column){
                if(rooms[row][column] == 0) {
                    gates.add(new Point(row, column));
                }
            }
        }
        
        return gates;
    }
    
    private void breadthFirstSearch(Point gate, int[][] rooms){
        final Queue<Point> q = new LinkedList<>();
        q.add(gate);
        
        final int numOfRows = rooms.length;
        final int numOfColumns = rooms[0].length;
        
        while(!q.isEmpty()){
            final Point curPoint = q.remove();
            final int rowOfCurPoint = curPoint.getRow();
            final int columnOfCurPoint = curPoint.getColumn();
            
            for(int i = 0; i < 4; ++ i){
                final int rowOfNextPoint = rowOfCurPoint + directions[i][0];
                final int columnOfNextPoint = columnOfCurPoint + directions[i][1];
                final Point nextPoint = new Point( rowOfNextPoint, columnOfNextPoint );
                
                if(isOutOfRoom(nextPoint, numOfRows, numOfColumns)) {
                    continue ;
                }
                
                final int distance = rooms[rowOfCurPoint][columnOfCurPoint] + 1;
                if(distance < rooms[rowOfNextPoint][columnOfNextPoint]){
                    rooms[rowOfNextPoint][columnOfNextPoint] = distance;
                    q.add(nextPoint);
                }
            }
        }
    }
    
    private boolean isOutOfRoom(Point point, int numOfRows, int numOfColumns){
        final int rowOfPoint = point.getRow();
        final int columnOfPoint = point.getColumn();
        return rowOfPoint < 0 || rowOfPoint >= numOfRows || columnOfPoint < 0 || columnOfPoint >= numOfColumns;
    }
}
