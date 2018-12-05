package s0000;

/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
import java.util.*;


public class ST0022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        help(list, "", n, n);
        return list;
    }
    private void help(List<String> list, String parent, int left, int right) {
        if (left==0 && right==0) {
            list.add(parent);
            return;
        }
        if (left > 0) {
            help(list, parent+"(", left-1, right);
        }
        if (right > left) {  //note: it is right > left
            help(list, parent+")", left, right-1);
        }
    }
}
