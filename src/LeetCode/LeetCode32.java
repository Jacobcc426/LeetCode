package LeetCode;

import java.util.Stack;

public class LeetCode32 {
    public static void main(String[] args) {
        LeetCode32 leetCode32 = new LeetCode32();
        System.out.println(leetCode32.longestValidParentheses(")()())()()()"));
    }
    public int longestValidParentheses(String s) {
        if(s.length()==0)
            return 0;
        int result = 0;
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(-1);
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                integerStack.push(i);
            }else if(s.charAt(i)==')'){
                int l = integerStack.pop();
                if(!integerStack.empty()){
                    result = Math.max(i-integerStack.peek(),result);
                }else
                    integerStack.push(i);
            }
        }

        return result;
    }
}
