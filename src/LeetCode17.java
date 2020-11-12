import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }
    Map<Integer,String> phoneMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        phoneMap.put(2,"abc");
        phoneMap.put(3,"def");
        phoneMap.put(4,"ghi");
        phoneMap.put(5,"jkl");
        phoneMap.put(6,"mno");
        phoneMap.put(7,"pqrs");
        phoneMap.put(8,"tuv");
        phoneMap.put(9,"wxyz");
        List<String> list = new ArrayList<>();
        if(!"".equals(digits)){
            combinations(digits, 0, new String(), list);
        }
        return list;
    }
    void combinations(String digits,int index,String strtemp,List<String> result){
        if(index==digits.length()){
            result.add(strtemp);
            return;
        }
        char[] chars = phoneMap.get(new Integer(""+digits.charAt(index))).toCharArray();
        StringBuffer sb = new StringBuffer(strtemp);
        for (char aChar : chars) {
            sb.append(aChar);
            combinations(digits,index+1,sb.toString(),result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
