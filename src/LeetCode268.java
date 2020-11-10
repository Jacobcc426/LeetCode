import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode268 {
}

class LeetCode268Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set set = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}