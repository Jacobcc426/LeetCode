package LeetCode;

public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(LeetCode5Solution.longestPalindrome("babad"));
    }
}
class LeetCode5Solution {
    public static String longestPalindrome(String s) {
        int maxlength = 0;
        String maxStr = "";
        StringBuffer temp = new StringBuffer("#");
        for(int i=0;i<s.length();i++){
            temp.append(s.charAt(i));
            temp.append("#");
        }
        s = temp.toString();
        for(int i=1;i<s.length();i++){
            int templength = 1;
            while((i-templength)>=0&&(i+templength)<s.length()){
                if(s.charAt(i-templength)==s.charAt(i+templength)){
                    if((2*templength+1)>maxlength){
                        maxStr = s.substring(i-templength,i+templength+1);
                    }
                    maxlength = Math.max(maxlength,2*templength+1);
                }else{
                    break;
                }
                templength++;
            }
        }
        return maxStr.replaceAll("#","");
    }
}