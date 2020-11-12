package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode8 {
    public static void main(String[] args) {
        System.out.println(LeetCode8Solution.myAtoi("-+12"));
    }
}

class LeetCode8Solution {
    public static int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0||!(Character.isDigit(s.charAt(0))||s.charAt(0)=='-'||s.charAt(0)=='+')){
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        int i =0;
        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
            i++;
            if(s.length()==1||!Character.isDigit(s.charAt(1))){
                return 0;
            }
            if(s.charAt(0)=='-'){
                sb.append("-");
            }
        }
        Long tempLong =0L;

        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
            tempLong = Long.parseLong(sb.toString());
            if(tempLong>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(tempLong<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return tempLong.intValue();
    }
}

class Solution8 {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
