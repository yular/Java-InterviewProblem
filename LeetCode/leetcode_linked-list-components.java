/*
*
* Tag: Data Structure
* Time: O(n)
* Space: O(n)
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int numOfComponents = 0;
        if(head == null){
            return numOfComponents;
        }
        
        ListNode p = head;
        Set<Integer> setG = new HashSet<>(Arrays.stream(G).boxed().collect(Collectors.toList()));
        boolean lastValueIsInG = false;
        while(p != null){
            int value = p.val;
            if(setG.contains(value)) {
                lastValueIsInG = true;
            } else {
                if(lastValueIsInG)
                    ++ numOfComponents;
                lastValueIsInG = false;
            }
            p = p.next;
        }
        
        return lastValueIsInG ? numOfComponents + 1 : numOfComponents;
    }
}
