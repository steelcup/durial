package s0001;

/*
13. Roman to Integer
Easy

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3

Example 2:

Input: "IV"
Output: 4

Example 3:

Input: "IX"
Output: 9

Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


 */
public class ST0013 {
    public int romanToInt(String s) {
        int sum=0;
        char[] cs =s.toCharArray();
        char c;
        for (int i = 0; i < cs.length; i++) {
            c = cs[i];
            switch (c) {
                case 'M':
                    sum += checkPrevious(cs, i, 'C', 1000, 100);
                    break;
                case 'D':
                    sum += checkPrevious(cs, i, 'C', 500, 100);
                    break;
                case 'C':
                    sum += checkPrevious(cs, i, 'X', 100, 10);
                    break;
                case 'L':
                    sum += checkPrevious(cs, i, 'X', 50, 10);
                    break;
                case 'X':
                    sum += checkPrevious(cs, i, 'I', 10, 1);
                    break;
                case 'V':
                    sum += checkPrevious(cs, i, 'I', 5, 1);
                    break;
                case 'I':
                    sum++;
                    break;
            }
        }
        /*
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

       for(;count<=s.length()-1;count++){
           if(c[count]=='M') sum+=1000;
           if(c[count]=='D') sum+=500;
           if(c[count]=='C') sum+=100;
           if(c[count]=='L') sum+=50;
           if(c[count]=='X') sum+=10;
           if(c[count]=='V') sum+=5;
           if(c[count]=='I') sum+=1;

       }
       */
        return sum;
    }

    private int checkPrevious(char[]cs, int idx, char c, int amaount, int deduct) {
        if (idx ==0) {
            return amaount;
        }
        return cs[idx-1]==c?amaount-2*deduct:amaount; //double because the previous got added already before
    }
}