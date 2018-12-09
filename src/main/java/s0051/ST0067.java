package s0051;
/*
67. Add Binary
Easy

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


 */
public class ST0067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry=0;
        int i = a.length()-1, j = b.length()-1;
        while(i >=0 || j>=0) {
            int x = i >=0?a.charAt(i--)-'0':0;
            int y = j >=0?b.charAt(j--)-'0':0;
            sb.insert(0, (x+y+carry)%2);
            carry = (x+y+carry)/2;
        }
        if (carry != 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
