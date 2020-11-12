package LeetCode;

import java.util.Stack;

public class LeetCode71 {
}
class LeetCode71Solution {
    public static void main(String[] args) {
        LeetCode71Solution solution = new LeetCode71Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }
    public String simplifyPath(String path) {
        Stack<String> stringStack = new Stack<>();
        String[] strs = path.split("/");
        for(String str:strs){
            if(str.equals("..")){
                if(!stringStack.empty()){
                    stringStack.pop();
                }
            }else if(!str.equals(".")&&!str.equals("")){
                stringStack.push(str);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stringStack.empty()) {
            stringBuffer.insert(0,stringStack.pop());
            stringBuffer.insert(0,"/");
        }
        if(stringBuffer.length()==0)
            return "/";
        return stringBuffer.toString();
    }
}