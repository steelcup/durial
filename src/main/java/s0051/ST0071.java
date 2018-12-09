package s0051;
/*
71. Simplify Path
Medium

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/a/../../b/../c//.//", => "/c"
path = "/a//b////c/d//././/..", => "/a/b/c"

In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".


 */
import java.util.*;

public class ST0071 {
    public String simplifyPath(String path) {
        String[] tks = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : tks) {
            if (s.equals(".") || s.length() == 0) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        //need to build from the back
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size()-1; i >= 0; i--) { //get from the end first
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
