/*
*
* Tag: BFS
* Time: O(n)
* Space: O(n)
*/
public class Solution {
    private final static int CEO = 0;
    /**
     * @param t: the time of each employee to pass a meeage
     * @param subordinate: the subordinate of each employee
     * @return: the time of the last staff recieve the message
     */
    public int deliverMessage(int[] t, int[][] subordinate) {
        int ans = 0;
        if(t == null || t.length == 0)
            return ans;
        
        int numOfPersions = t.length;
        int[] receiveMessageTime = new int[numOfPersions];
        Queue<Integer> messageSenders = new LinkedList<>();
        messageSenders.add(CEO);
        
        while(!messageSenders.isEmpty()){
            int currentSender = messageSenders.poll();
            for(int nextSender : subordinate[currentSender]) {
                if(nextSender == -1)
                    break;
                receiveMessageTime[nextSender] = receiveMessageTime[currentSender] + t[currentSender];
                messageSenders.add(nextSender);
                ans = Math.max(ans, receiveMessageTime[nextSender]);
            }
        }
        
        return ans;
    }
}
