/*
*
* Tag: DFS
* Time: O(n)
* Space: O(n)
*/
class Solution {
    private int numOfVisitedRooms;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visitedRooms = new ArrayList<>(Collections.nCopies(rooms.size(), false));
        if(rooms.size() == 0) {
            return true;
        }
        
        numOfVisitedRooms = 0;
        int totalNumOfRooms = rooms.size();
        dfs(0, rooms, visitedRooms);
        
        return numOfVisitedRooms == totalNumOfRooms;
    }
    
    private void dfs(int currentRoom, List<List<Integer>> rooms, List<Boolean> visitedRooms) {
        visitedRooms.set(currentRoom, true);
        ++ numOfVisitedRooms;
        
        for(Integer nextRoom : rooms.get(currentRoom) ) {
            if(!visitedRooms.get(nextRoom)) {
                dfs(nextRoom, rooms, visitedRooms);
            }
        }
    }
}
