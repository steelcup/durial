package s0001;

/*
17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

import java.util.*;

public class ST0017 {
    char[][] cl = {//0~9
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    //recursive
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length()==0) {
            return list;
        }
        helper(list, new StringBuilder(), digits, 0);
        return list;
    }

    private void helper(List<String> list, StringBuilder sb, String digits, int start) {
        if (start == digits.length()) {//or sb.length(0 == ) digits.length()
            list.add(sb.toString());
            return;
        }
        int row = digits.charAt(start)-'0';
        for (int i = 0; i < cl[row].length; i++) {
            sb.append(cl[row][i]);
            helper(list, sb, digits, start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /* counting numbers
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits ==null || digits.length()==0) {
            return list;
        }
		int[]a = new int[digits.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = digits.charAt(i)-'0';
		}
		int[]idx = new int[a.length];

		StringBuilder sb = new StringBuilder();
		while (true) {
			int carry = 0;
			for (int i = idx.length-1; i >= 0; i--) {
				idx[i] +=carry;
				if (idx[i] == cl[a[i]].length) {
					idx[i]=0;
					carry = 1;
				} else {
                    carry=0;
					break;
				}
			}
			if (carry==1) {//over
				break;
			} else {
				list.add(convert(sb, a, idx));
			}
			idx[idx.length-1]++;
		}
		return list;
	}

	private String convert(StringBuilder sb, int[]a, int[]idx) {
		sb.setLength(0);
		for (int i = 0; i < idx.length; i++) {
			sb.append(cl[a[i]][idx[i]]);
		}
		return sb.toString();
    }
    */
}
