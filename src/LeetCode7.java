import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(LeetCode7Solution.reverse(1534236469));
    }
}

class LeetCode7Solution {
    public static int reverse(int x) {
        Long max ;
        Long min ;
        Long temp = Long.valueOf(2);
        for(int i=0;i<30;i++){
            temp = temp*2;
        }
        min = -temp;
        max = temp-1;

        String origin = String.valueOf(x);
        StringBuffer reversesb = new StringBuffer();
        if(x<0){
            origin = origin.substring(1,origin.length());
            reversesb.append("-");
        }
        for(int j=origin.length()-1;j>=0;j--){
            reversesb.append(origin.charAt(j));
        }
        long reverseint = Long.parseLong(reversesb.toString());
        if(reverseint>max||reverseint<min){
            return 0 ;
        }else
            return Integer.parseInt(reversesb.toString());
    }
    public int reverse2(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}