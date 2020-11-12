<<<<<<< HEAD

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
=======
public class LeetCode10 {
}
class LeetCode10Solution1 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)=='*'){
                    if(j-1<0)
                        return false;
                    if(p.charAt(j-1)!=s.charAt(i)){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }if(p.charAt(j-1)==s.charAt(i)||p.charAt(j-1)=='.'){
                        //dp[i][j+1] 匹配多次，p串仍在j位置，s串i++
                        //dp[i+1][j] 匹配一次，j++后为*，i不变
                        //dp[i+1][j-1] 不匹配
                        dp[i+1][j+1] =dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    class LeetCode10Solution2 {
        public boolean isMatch1(String s, String p) {
            if(p.isEmpty()) return s.isEmpty();
            boolean match = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
            if(p.length() >= 2 && p.charAt(1) == '*') return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
            return match && isMatch(s.substring(1), p.substring(1));
        }
        public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
            if(p1 >= p.length) return s1 >= s.length;
            boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
            if(p.length - p1 >= 2 && p[p1 + 1] == '*') return isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
            return match && isMatchChar(s, s1 + 1, p, p1 + 1);
        }
        public boolean isMatch2(String s, String p) {
            char[] ss = s.toCharArray(), pp = p.toCharArray();
            return isMatchChar(ss, 0, pp, 0);
        }
    }
    class LeetCode10Solution3 {
        int[][] mem;
        public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
            if(p1 >= p.length) return s1 >= s.length;
            if(mem[s1][p1] != 0) return mem[s1][p1] > 0;
            boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
            if(p.length - p1 >= 2 && p[p1 + 1] == '*') {
                boolean t = isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
                if(t) mem[s1][p1] = 1;
                else mem[s1][p1] = -1;
                return t;
            }
            boolean t = match && isMatchChar(s, s1 + 1, p, p1 + 1);
            if(t) mem[s1][p1] = 1;
            else mem[s1][p1] = -1;
            return t;
        }
        public boolean isMatch(String s, String p) {
            this.mem = new int[s.length() + 1][p.length() + 1];
            char[] ss = s.toCharArray(), pp = p.toCharArray();
            return isMatchChar(ss, 0, pp, 0);
        }
    }

>>>>>>> origin/master
}
