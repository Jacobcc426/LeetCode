
import java.util.Map;
import java.util.TreeMap;

public class LeetCode11 {
    public static void main(String[] args) {
        System.out.println(new LeetCode11().maxArea(new int[]{4,3,2,1,4}));
    }
    public int maxArea(int[] height) {
        int max = 0;
        int i=0,j=height.length-1;
        while (j>i){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }
}
