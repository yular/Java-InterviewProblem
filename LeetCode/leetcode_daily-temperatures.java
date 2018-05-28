/*
*
* Tag: Data Structure
* Time: O(n)
* Space: O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        if(temperatures.length == 0){
            return ans;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; ++ i){
            updateDaatesForWarmerTemperature( i, stack, temperatures, ans );
            stack.push(i);
        }
        
        return ans;
    }
    
    private void updateDaatesForWarmerTemperature( int curIndex, Stack<Integer> stack, int[] temperatures, int[] ans ){
        while(!stack.isEmpty()){
            int lastIndex = stack.peek();
            if(temperatures[lastIndex] < temperatures[curIndex]){
                ans[lastIndex] = curIndex - lastIndex;
                stack.pop();
            } else {
                break;
            }
        }
    }
}
