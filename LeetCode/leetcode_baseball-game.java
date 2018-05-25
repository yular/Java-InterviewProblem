/*
*
* Tag: Data Structure
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        
        for(String op : ops){
            int value = 0;
            if( op.equals("C") ) {
                stack.pop();
                continue;
            }
            
            if( op.equals("D") ) {
                value = 2*stack.peek();
            } else if( op.equals("+") ) {
                int topValue = stack.pop();
                value = topValue + stack.peek();
                stack.push( topValue );
            } else {
                value = Integer.valueOf( op );
            }
            
            stack.push( value );
        }
        
        int ans = 0;
        for(int value : stack ){
            ans += value;
        }
        
        return ans;
    }
}
