package s0000;

/*
9. Palindrome Number
Easy

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */
public class ST0009 {
    public boolean isPalindrome(int x) {
        //reverse and compare
        if (x < 0) {
            return false;
        }
        int r = 0;
        int y = x;
        while (y != 0) {
            r = r*10 + y%10;
            y /=10;
        }
        return r==x;
    }
}
