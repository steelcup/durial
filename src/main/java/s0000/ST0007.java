package s0000;

/*
7. Reverse Integer
Easy

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

 */

public class ST0007 {
    public int reverse(int x) {
        int r = 0, tmp, tail;
        while (x != 0) {
            tail = x%10; //while x==-11  tail=-1
            tmp = r*10 + tail;
            if (r != (tmp-tail)/10) {
                return 0;//overfloat
            }
            r = tmp;
            x = x/10;
        }
        return r;
    }
}
