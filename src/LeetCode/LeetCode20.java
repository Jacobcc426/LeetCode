package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode20 {
}
class LeetCode20Solution {
    Stack<Character> stack;
    String left = "([{";
    String right = ")]}";
    public boolean isValid(String s) {
        stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(char ch:chs){
            if(left.indexOf(ch)!=-1){
                stack.push(ch);
            }else if(stack.empty()||stack.pop()!=left.charAt(right.indexOf(ch))){
                return false;
            }
        }
        return stack.empty();
    }
}