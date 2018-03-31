/*
*
* Tag: Implementation
* Time: O(1)
* Space: O(1)
*/
public class Solution {
    /**
     * @param n: a number represent year
     * @return: whether year n is a leap year.
     */
    public boolean isLeapYear(int n) {
        return (n%4 == 0 && n%100 != 0) || (n%400 == 0);
    }
}
