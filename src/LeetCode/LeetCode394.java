package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode394 {
}
class LeetCode394Solution {
    public static void main(String[] args) {
        LeetCode394Solution leetCode394Solution = new LeetCode394Solution();
        System.out.println(leetCode394Solution.decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        int num = 0;
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        //字母、数字、左括号、右括号
        for(int i=0;i<chars.length;i++){
            if(Character.isLetter(chars[i])){
                stringBuffer.append(chars[i]);
            }else if('['==chars[i]){
                numStack.push(num);
                strStack.push(stringBuffer.toString());
                stringBuffer=new StringBuffer();
                num=0;
            }else  if(']'==chars[i]){
                StringBuffer temp = new StringBuffer();
                int tempnum = numStack.pop();
                for(int j=0;j<tempnum;j++) {
                    temp.append(stringBuffer.toString());
                }
                stringBuffer=new StringBuffer(strStack.pop()+temp);
            }else if(Character.isDigit(chars[i]))
                num = num*10 +Integer.parseInt(chars[i]+"");
        }
        return stringBuffer.toString();
    }
}