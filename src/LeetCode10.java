
public class LeetCode10 {
    public static void main(String[] args) {
        LeetCode10 leetCode10 = new LeetCode10();
        System.out.println(leetCode10.isMatch("aa", "a*"));
    }
    public boolean isMatch(String s, String p) {
        int i =0,j=0;
        return match(s,i,p,j);
    }

    boolean match(String s,int i,String p,int j){
        if(j==p.length())
            return i==s.length();
        boolean match = i!=s.length()&&(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.');
        if(p.length()-1>j && p.charAt(j+1) == '*')
            return match(s,i,p,j+2) || (match&&match(s,i+1,p,j));
        return match && match(s,i+1,p,j+1);
    }
}
