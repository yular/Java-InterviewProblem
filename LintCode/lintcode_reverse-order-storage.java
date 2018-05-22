/*
*
* Tag: Implementation
* Time: O(n)
* Space: O(1)
*/
public class Solution {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        final List<Integer> ans = new ArrayList<>();
        if( head == null ) {
            return ans;
        }
        
        ListNode pointer = head;
        while( pointer != null ) {
            ans.add( pointer.val );
            pointer = pointer.next;
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
