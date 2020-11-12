package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {
    public static void main(String[] args) {
        System.out.println(LeetCode6Solution.convert("LEETCODEISHIRING",3));
    }
}
class LeetCode6Solution {
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<List<Character>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Character> characterList = new ArrayList<>();
            list.add(characterList);
        }
        int i=0;
        int row = 0;
        //true 向下  false 向上
        boolean flag = true;
        while(i<s.length()){
            list.get(row).add(s.charAt(i));
            if(flag){
                if(row==numRows-1) {
                    flag = false;
                    row--;
                }else{
                    row++;
                }
            }else{
                if(row==0){
                    flag=true;
                    row++;
                }else {
                    row--;
                }
            }
            i++;
        }
        StringBuffer sb = new StringBuffer();
        for(List<Character> list1:list){
            for(char ch:list1){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}